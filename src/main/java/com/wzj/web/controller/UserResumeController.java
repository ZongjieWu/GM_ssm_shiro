package com.wzj.web.controller;
import com.wzj.model.UserResume;
import com.wzj.service.service.UserResumeService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/30.
 */
@Api(tags="用户简历")
@RestController
@RequestMapping("/userResume/")
public class UserResumeController {

    @Autowired
    private UserResumeService userResumeService;

    @PostMapping("add")
    @ApiOperation("添加简历")
    public Map<String,Object> add(@RequestBody @ApiParam("用户简历") UserResume userResume) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userResume.setAddTime(simpleDateFormat.format(new Date()));
        userResume.setModifyTime(simpleDateFormat.format(new Date()));
        userResumeService.save(userResume);
        return Result.retrunSucess();
    }

    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    userResumeService.deleteById(id);
	    return Result.retrunSucess();
    }

    @PostMapping("update")
    public Map<String,Object> update(UserResume userResume) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userResume.setModifyTime(simpleDateFormat.format(new Date()));
	    userResumeService.update(userResume);
	    return Result.retrunSucess();
    }

    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        UserResume userResume = userResumeService.findById(id);
        return Result.retrunSucessMsgData(userResume);
    }

    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,String keywords) {
        Example example=new Example(UserResume.class);
        Example.Criteria criteria=example.createCriteria();
        if(keywords==null){
        }else{
            criteria.andCondition(" (name like '%"+keywords+"%' or phone like '%"+keywords+"%')");
        }
        PageHelper.startPage(page, limit);
        PageInfo<UserResume> userResumePageInfo = userResumeService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(userResumePageInfo.getList());
        map.put("count",userResumePageInfo.getTotal());
        return map;
    }
}
