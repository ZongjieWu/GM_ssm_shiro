package com.wzj.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.enums.Result;
import com.wzj.model.RemitRecord;
import com.wzj.service.service.EnterpriseService;
import com.wzj.service.service.RemitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/26.
 */
@ApiIgnore
@RestController
@RequestMapping("/api/remitRecord/")
public class ApiRemitRecord {

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
        remitRecord.setModifyTime(simpleDateFormat.format(new Date()));
	    remitRecordService.update(remitRecord);
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
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(RemitRecord.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<RemitRecord> remitRecordPageInfo = remitRecordService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(remitRecordPageInfo.getList());
        map.put("count",remitRecordPageInfo.getTotal());
        return map;
    }
}
