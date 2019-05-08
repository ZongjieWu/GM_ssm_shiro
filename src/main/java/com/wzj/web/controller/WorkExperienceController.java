package com.wzj.web.controller;
import com.wzj.model.WorkExperience;
import com.wzj.service.service.WorkExperienceService;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/08.
 */
@ApiIgnore
@RestController
@RequestMapping("/workExperience/")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(WorkExperience workExperience) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workExperience.setAddTime(simpleDateFormat.format(new Date()));
        workExperience.setModifyTime(simpleDateFormat.format(new Date()));
        workExperienceService.save(workExperience);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    workExperienceService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(WorkExperience workExperience) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workExperience.setModifyTime(simpleDateFormat.format(new Date()));
	    workExperienceService.update(workExperience);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        WorkExperience workExperience = workExperienceService.findById(id);
        return Result.retrunSucessMsgData(workExperience);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(WorkExperience.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<WorkExperience> workExperiencePageInfo = workExperienceService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(workExperiencePageInfo.getList());
        map.put("count",workExperiencePageInfo.getTotal());
        return map;
    }
}
