package com.wzj.web.controller;
import com.wzj.model.Enterprise;
import com.wzj.model.User;
import com.wzj.service.service.EnterpriseService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * Created by Zongjie Wu on 2019/04/11.
 */
@ApiIgnore
@RestController
@RequestMapping("/enterprise/")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(Enterprise enterprise) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        enterprise.setAddTime(simpleDateFormat.format(new Date()));
        enterprise.setModifyTime(simpleDateFormat.format(new Date()));
        enterpriseService.save(enterprise);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    enterpriseService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(Enterprise enterprise) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        enterprise.setModifyTime(simpleDateFormat.format(new Date()));
        if(enterprise==null||enterprise.getStatus()==null){
            return Result.retrunFail();
        }else if (enterprise.getStatus()==1){
//            Enterprise e=enterpriseService.findById(enterprise.getId());
//            //还没到期
//            try {
//                if(e.getServiceEndTime()==null||sdf.parse(e.getServiceEndTime()).getTime()<=new Date().getTime()){
//                    //已经到期
//                    String data=simpleDateFormat.format(new Date());
//                    Integer year=Integer.valueOf(data.split("-")[0])+Integer.valueOf(enterprise.getServiceType().split("/")[1]);
//                    String month=data.split("-")[1];
//                    String day=data.split("-")[2];
//                    e.setServiceEndTime(year+"-"+month+"-"+day);
//                    e.setServiceType(enterprise.getServiceType());
//                    e.setModifyTime(simpleDateFormat.format(new Date()));
//                    e.setStatus(1);
//                    enterpriseService.update(e);
//                }else{
//                    String data=e.getServiceEndTime();
//                    Integer year=Integer.valueOf(data.split("-")[0])+Integer.valueOf(enterprise.getServiceType().split("/")[1]);
//                    String month=data.split("-")[1];
//                    String day=data.split("-")[2];
//                    e.setServiceEndTime(year+"-"+month+"-"+day);
//                    e.setServiceType(enterprise.getServiceType());
//                    e.setModifyTime(simpleDateFormat.format(new Date()));
//                    e.setStatus(1);
//                    enterpriseService.update(e);
//                }
//
//            } catch (ParseException e1) {
//                e1.printStackTrace();
//            }
            enterprise.setAuthenticationTime(simpleDateFormat.format(new Date()));
            enterprise.setModifyTime(simpleDateFormat.format(new Date()));
            enterpriseService.update(enterprise);
        }else {
            enterpriseService.update(enterprise);
        }
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        Enterprise enterprise = enterpriseService.findById(id);
        return Result.retrunSucessMsgData(enterprise);
    }

    @ApiIgnore
    @PostMapping("batchUpdate")
    public Map<String,Object> batchUpdate(String ids,Integer status) {
        Enterprise enterprise=null;
        String[] idsArr=ids.split(",");
        for(int i=0;i<idsArr.length;i++){
            enterprise=new Enterprise();
            enterprise.setId(Long.valueOf(idsArr[i]));
            enterprise.setStatus(status);
            enterpriseService.update(enterprise);
        }
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("batchAuthentication")
    public Map<String,Object> batchAuthentication(String ids,Integer authenticationStatus) {
        String[] idsArr=ids.split(",");
        Enterprise enterprise=null;
        for(int i=0;i<idsArr.length;i++){
            enterprise=new Enterprise();
            enterprise.setId(Long.valueOf(idsArr[i]));
            enterprise.setAuthenticationStatus(authenticationStatus);
            enterpriseService.update(enterprise);
        }
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("authentication")
    public Map<String,Object> authentication(Enterprise enterprise) {
        if(enterprise.getId()==null){
            return Result.retrunFail();
        }else{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            enterprise.setModifyTime(simpleDateFormat.format(new Date()));
            if(enterprise==null||enterprise.getStatus()==null){
            }else if(enterprise.getStatus()==2){
                enterprise.setAuthenticationTime(simpleDateFormat.format(new Date()));
            }
            enterpriseService.update(enterprise);
            Enterprise e=enterpriseService.findById(enterprise.getId());
            return Result.retrunSucessMsgData(e);
        }
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,Integer status,Integer authenticationStatus,String keywords) {
        Example example=new Example(Enterprise.class);
        Example.Criteria criteria=example.createCriteria();
        if(status==null){
        }else{
            criteria.andEqualTo("status",status);
        }
        if(authenticationStatus==null){
        }else{
            criteria.andEqualTo("authenticationStatus",authenticationStatus);
        }
        if(keywords==null||keywords.equals("")){
        }else{
            criteria.andCondition(" (phone like '%"+keywords+"%' or name like '%"+keywords+"%')");
        }
        PageHelper.startPage(page, limit);
        PageInfo<Enterprise> enterprisePageInfo = enterpriseService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(enterprisePageInfo.getList());
        map.put("count",enterprisePageInfo.getTotal());
        return map;
    }
}
