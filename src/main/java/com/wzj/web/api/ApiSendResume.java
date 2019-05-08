package com.wzj.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.enums.Result;
import com.wzj.model.Enterprise;
import com.wzj.model.SendResume;
import com.wzj.model.User;
import com.wzj.service.service.EnterpriseService;
import com.wzj.service.service.SendResumeService;
import com.wzj.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@Api(tags="发送简历")
@RestController
@RequestMapping("/api/sendResume/")
public class ApiSendResume {

    @Autowired
    private SendResumeService sendResumeService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private UserService userService;

    @ApiOperation("发送简历")
    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(SendResume sendResume) {
//        User user=
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendTime=sendResumeService.queryLastSendTime(sendResume.getUid(),sendResume.getIssueJobId());
        Date sendDate=null;
        try {
            if(sendTime==null){
            }else{
                sendDate=simpleDateFormat.parse(sendTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user=userService.findById(sendResume.getUid());
        if(user.getAuthenticationStatus()==0){
            return Result.retrunFailMsg("请认证后投递");
        }else if(user.getAuthenticationStatus()==1){
            return Result.retrunFailMsg("等待认证成功后投递");
        }else if(user.getAuthenticationStatus()==3){
            return Result.retrunFailMsg("认证失败,请重新认证后投递");
        }
        if(sendTime==null||((new Date().getTime()-sendDate.getTime())/(1000*3600*24))>30){
            sendResume.setAddTime(simpleDateFormat.format(new Date()));
            sendResume.setModifyTime(simpleDateFormat.format(new Date()));
            sendResumeService.save(sendResume);
            return Result.retrunSucess();
        }else{
            return Result.retrunFailMsg("一个月内不能重复投递");
        }

    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    sendResumeService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(SendResume sendResume) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sendResume.setModifyTime(simpleDateFormat.format(new Date()));
	    sendResumeService.update(sendResume);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        SendResume sendResume = sendResumeService.findById(id);
        return Result.retrunSucessMsgData(sendResume);
    }
    @ApiIgnore
    @PostMapping("pagingByEnterpriseId")
    public Map<String,Object> pagingByEnterpriseId(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,String keywords,Long id) {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Enterprise enterprise=enterpriseService.findById(id);
//        try {
//            if(sdf.parse(enterprise.getServiceEndTime()).getTime()<sdf.parse(sdf.format(new Date())).getTime()){
//                return Result.retrunFailMsgData("请续费后重新登入",-1);
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        PageHelper.startPage(page, limit);
        PageInfo<Map<String,Object>> sendResumePageInfo = sendResumeService.pagingByEnterpriseId(" sr.id desc",page,limit,keywords,id);
        Map<String,Object> map=Result.retrunSucessMsgData(sendResumePageInfo.getList());
        map.put("count",sendResumePageInfo.getTotal());
        return map;
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,String keywords,Long uid) {
        PageHelper.startPage(page, limit);
        PageInfo<Map<String,Object>> sendResumePageInfo = sendResumeService.paging(" sr.id desc",page,limit,keywords,uid);
        Map<String,Object> map=Result.retrunSucessMsgData(sendResumePageInfo.getList());
        map.put("count",sendResumePageInfo.getTotal());
        return map;
    }
}
