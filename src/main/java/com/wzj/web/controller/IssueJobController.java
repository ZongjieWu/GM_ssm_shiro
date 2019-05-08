package com.wzj.web.controller;
import com.wzj.model.IssueJob;
import com.wzj.service.service.IssueJobService;
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
@Api(tags="发布职位")
@RestController
@RequestMapping("/issueJob/")
public class IssueJobController {

    @Autowired
    private IssueJobService issueJobService;

    @ApiOperation("发布职位")
    @PostMapping("add")
    public Map<String,Object> add(@RequestBody @ApiParam("发布职位") IssueJob issueJob) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        issueJob.setAddTime(simpleDateFormat.format(new Date()));
        issueJob.setModifyTime(simpleDateFormat.format(new Date()));
        issueJobService.save(issueJob);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    issueJobService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(IssueJob issueJob) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        issueJob.setModifyTime(simpleDateFormat.format(new Date()));
	    issueJobService.update(issueJob);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        IssueJob issueJob = issueJobService.findById(id);
        return Result.retrunSucessMsgData(issueJob);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,String keywords) {
        Example example=new Example(IssueJob.class);
        Example.Criteria criteria=example.createCriteria();
        if(keywords==null||keywords.equals("")){
        }else{
            criteria.andCondition(" (enterprise_name like '%"+keywords+"%' or job_name like '%"+keywords+"%')");
        }
        PageHelper.startPage(page, limit);
        PageInfo<IssueJob> issueJobPageInfo = issueJobService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(issueJobPageInfo.getList());
        map.put("count",issueJobPageInfo.getTotal());
        return map;
    }
}
