package com.wzj.web.controller;
import com.wzj.model.InterviewNotify;
import com.wzj.model.User;
import com.wzj.model.WeChatPublicConfig;
import com.wzj.service.service.InterviewNotifyService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.service.service.UserService;
import com.wzj.service.service.WeChatPublicConfigService;
import com.wzj.util.WeChatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@Api(tags="面试通知")
@RestController
@RequestMapping("/interviewNotify/")
public class InterviewNotifyController {

    @Autowired
    private InterviewNotifyService interviewNotifyService;
    @Autowired
    private WeChatPublicConfigService weChatPublicConfigServiceService;
    @Autowired
    private UserService userService;

    @ApiOperation("面试通知")
    @PostMapping("add")
    public Map<String,Object> add(@RequestBody @ApiParam("面试通知") InterviewNotify interviewNotify) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        interviewNotify.setAddTime(simpleDateFormat.format(new Date()));
        interviewNotify.setModifyTime(simpleDateFormat.format(new Date()));
        interviewNotifyService.save(interviewNotify);


        /**
         * 微信公众号面试通知消息推送
         * */
        User u=new User();
        u.setId(interviewNotify.getUserId());
        User user=userService.findOne(u);
        if(user.getWechatPublicOpenid()!=null){
            Map<String,Object> map=new HashMap<>();
            map.put("openid",user.getWechatPublicOpenid());
            map.put("enterpriseName",interviewNotify.getEnterpriseName());
            map.put("jobName",interviewNotify.getJobName());
            map.put("content",interviewNotify.getContent());
            map.put("concatPhone",interviewNotify.getConcatPhone());
            WeChatUtil.interviewNotifyPush(weChatPublicConfigServiceService.findById(1L),map);
        }
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    interviewNotifyService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(InterviewNotify interviewNotify) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        interviewNotify.setModifyTime(simpleDateFormat.format(new Date()));
	    interviewNotifyService.update(interviewNotify);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        InterviewNotify interviewNotify = interviewNotifyService.findById(id);
        return Result.retrunSucessMsgData(interviewNotify);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,String keywords,Long uid) {
        PageInfo<InterviewNotify> interviewNotifyPageInfo = interviewNotifyService.paging(" itvnty.id desc",page,limit,keywords,uid);
        Map<String,Object> map=Result.retrunSucessMsgData(interviewNotifyPageInfo.getList());
        map.put("count",interviewNotifyPageInfo.getTotal());
        return map;
    }
}
