package com.wzj.web.controller;
import com.wzj.model.Enterprise;
import com.wzj.model.RemitRecord;
import com.wzj.service.service.EnterpriseService;
import com.wzj.service.service.RemitRecordService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;
import springfox.documentation.annotations.ApiIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/26.
 */
@ApiIgnore
@RestController
@RequestMapping("/remitRecord/")
public class RemitRecordController {

    @Autowired
    private RemitRecordService remitRecordService;
    @Autowired
    private EnterpriseService enterpriseService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(String phone,String pwd,String remitAuthentication) {
        Map<String,Object> map=enterpriseService.login(phone,pwd);
        if(map==null){
            return Result.retrunFail();
        }else{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            RemitRecord remitRecord=new RemitRecord();
            remitRecord.setEnterpriseId(Long.valueOf(map.get("id").toString()));
            remitRecord.setEnterpriseName(map.get("name").toString());
            remitRecord.setEnterpriseLogo(map.get("logo").toString());
            remitRecord.setEnterprisePhone(map.get("phone").toString());
            remitRecord.setRemitAuthentication(remitAuthentication);
            remitRecord.setAddTime(sdf.format(new Date()));
            remitRecord.setModifyTime(sdf.format(new Date()));
            remitRecordService.save(remitRecord);
            return Result.retrunSucess();
        }
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    remitRecordService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(RemitRecord remitRecord) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(remitRecord==null||remitRecord.getStatus()==null){
            return Result.retrunFail();
        }else if (remitRecord.getStatus()==1){
            /***
             * 到期了的充值从今天开始算
             * 还没到期的从到期的那天开始算
             * */
            RemitRecord rr = remitRecordService.findById(remitRecord.getId());
            Enterprise enterprise=enterpriseService.findById(rr.getEnterpriseId());
            try {
                //还没到期
                if(enterprise.getServiceEndTime()==null||sdf.parse(enterprise.getServiceEndTime()).getTime()<=new Date().getTime()){
                    String data=sdf.format(new Date());
                    Integer year=Integer.valueOf(data.split("-")[0])+Integer.valueOf(remitRecord.getServiceType().split("/")[1]);
                    String month=data.split("-")[1];
                    String day=data.split("-")[2];
                    enterprise.setServiceEndTime(year+"-"+month+"-"+day);
                    enterprise.setModifyTime(simpleDateFormat.format(new Date()));
                    enterpriseService.update(enterprise);
                }else{
                    String data=enterprise.getServiceEndTime();
                    Integer year=Integer.valueOf(data.split("-")[0])+Integer.valueOf(remitRecord.getServiceType().split("/")[1]);
                    String month=data.split("-")[1];
                    String day=data.split("-")[2];
                    enterprise.setServiceEndTime(year+"-"+month+"-"+day);
                    enterprise.setModifyTime(simpleDateFormat.format(new Date()));
                    enterpriseService.update(enterprise);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            remitRecord.setEnterprisePhone(enterprise.getPhone());
            remitRecord.setAuthenticationTime(simpleDateFormat.format(new Date()));
            remitRecord.setModifyTime(simpleDateFormat.format(new Date()));
            remitRecordService.update(remitRecord);
        }
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        RemitRecord remitRecord = remitRecordService.findById(id);
        return Result.retrunSucessMsgData(remitRecord);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,Integer status,String keywords) {
        Example example=new Example(RemitRecord.class);
        Example.Criteria criteria=example.createCriteria();
        if(status==null){
        }else {
            criteria.andEqualTo("status",status);
        }
        if(keywords==null||keywords.equals("")){
        }else{
            criteria.andCondition(" (enterprise_name like '%"+keywords+"%' or enterprise_phone like '%"+keywords+"%')");
        }
        PageHelper.startPage(page, limit);
        PageInfo<RemitRecord> remitRecordPageInfo = remitRecordService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(remitRecordPageInfo.getList());
        map.put("count",remitRecordPageInfo.getTotal());
        return map;
    }
}
