package com.wzj.web.controller;
import com.wzj.model.JobType;
import com.wzj.service.service.JobTypeService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/30.
 */
@Api(tags = "职位类型")
@RestController
@RequestMapping("/jobType/")
public class JobTypeController {

    @Autowired
    JobTypeService jobTypeService;

    @ApiOperation("添加职位")
    @PostMapping("add")
    public Map<String,Object> add(@RequestBody @ApiParam("职位类型") JobType jobType) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jobType.setAddTime(simpleDateFormat.format(new Date()));
        jobType.setModifyTime(simpleDateFormat.format(new Date()));
        jobTypeService.save(jobType);
        return Result.retrunSucess();
    }

    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    jobTypeService.deleteById(id);
	    return Result.retrunSucess();
    }

    @PostMapping("update")
    public Map<String,Object> update(JobType jobType) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jobType.setModifyTime(simpleDateFormat.format(new Date()));
	    jobTypeService.update(jobType);
	    return Result.retrunSucess();
    }

    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        JobType jobType = jobTypeService.findById(id);
        return Result.retrunSucessMsgData(jobType);
    }

    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(JobType.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<JobType> jobTypePageInfo = jobTypeService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(jobTypePageInfo.getList());
        map.put("count",jobTypePageInfo.getTotal());
        return map;
    }
}
