package com.wzj.web.controller;
import com.wzj.model.SendResume;
import com.wzj.service.service.SendResumeService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@Api(tags="发送简历")
@RestController
@RequestMapping("/sendResume/")
public class SendResumeController {

    @Autowired
    private SendResumeService sendResumeService;

    @ApiOperation("发送简历")
    @PostMapping("add")
    public Map<String,Object> add(@RequestBody @ApiParam("发送简历") SendResume sendResume) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sendResume.setAddTime(simpleDateFormat.format(new Date()));
        sendResume.setModifyTime(simpleDateFormat.format(new Date()));
        sendResumeService.save(sendResume);
        return Result.retrunSucess();
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
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,String keywords,Long uid) {
        PageHelper.startPage(page, limit);
        PageInfo<Map<String,Object>> sendResumePageInfo = sendResumeService.paging(" sr.id desc",page,limit,keywords,uid);
        Map<String,Object> map=Result.retrunSucessMsgData(sendResumePageInfo.getList());
        map.put("count",sendResumePageInfo.getTotal());
        return map;
    }
}
