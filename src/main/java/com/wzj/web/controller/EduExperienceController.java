package com.wzj.web.controller;
import com.wzj.model.EduExperience;
import com.wzj.service.service.EduExperienceService;
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
 * Created by Zongjie Wu on 2019/04/09.
 */
@ApiIgnore
@RestController
@RequestMapping("/eduExperience/")
public class EduExperienceController {

    @Autowired
    private EduExperienceService eduExperienceService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(EduExperience eduExperience) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        eduExperience.setAddTime(simpleDateFormat.format(new Date()));
        eduExperience.setModifyTime(simpleDateFormat.format(new Date()));
        eduExperienceService.save(eduExperience);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    eduExperienceService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(EduExperience eduExperience) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        eduExperience.setModifyTime(simpleDateFormat.format(new Date()));
	    eduExperienceService.update(eduExperience);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        EduExperience eduExperience = eduExperienceService.findById(id);
        return Result.retrunSucessMsgData(eduExperience);
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(EduExperience.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<EduExperience> eduExperiencePageInfo = eduExperienceService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(eduExperiencePageInfo.getList());
        map.put("count",eduExperiencePageInfo.getTotal());
        return map;
    }
}
