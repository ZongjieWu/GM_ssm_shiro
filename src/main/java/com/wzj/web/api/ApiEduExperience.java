package com.wzj.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedHashTreeMap;
import com.sun.org.apache.regexp.internal.RE;
import com.wzj.enums.Result;
import com.wzj.model.EduExperience;
import com.wzj.model.WorkExperience;
import com.wzj.service.service.EduExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * Created by Zongjie Wu on 2019/04/09.
 */
@Validated
@ApiIgnore
@RestController
@RequestMapping("/api/eduExperience/")
public class ApiEduExperience {

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
    public Map<String,Object> update(String eduStrList) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gson=new Gson();
        List<Object> eduExperienceList=(List<Object>)gson.fromJson(eduStrList,Object.class);
        LinkedHashTreeMap map= new LinkedHashTreeMap();
        EduExperience eduExperience=null;
        for(int i=0,count=eduExperienceList.size();i<count;i++){
            map=(LinkedHashTreeMap) eduExperienceList.get(i);
            eduExperience=new EduExperience();
            eduExperience.setUserResumeId(Long.valueOf(map.get("userResumeId").toString().split("[.]")[0]));
            eduExperience.setName(map.get("name").toString());
            eduExperience.setMajor(map.get("major").toString());
            eduExperience.setStartTime(map.get("startTime").toString());
            eduExperience.setEndTime(map.get("endTime").toString());
            if(map.get("id")==null){
                eduExperience.setAddTime(simpleDateFormat.format(new Date()));
                eduExperienceService.save(eduExperience);
            }else{
                eduExperience.setId(Long.valueOf(map.get("id").toString()));
                eduExperience.setModifyTime(simpleDateFormat.format(new Date()));
                EduExperience e=new EduExperience();
                e.setUserResumeId(e.getUserResumeId());
                List<EduExperience> eduExperienceList1= eduExperienceService.queryListByWhere(e);
                for(int j=0,jcount=eduExperienceList1.size();j<jcount;j++){
                    if(eduExperienceList1.get(j).getId()==eduExperience.getId()){
                        eduExperienceService.update(eduExperience);
                    }
                }
            }
        }
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        EduExperience eduExperience = eduExperienceService.findById(id);
        return Result.retrunSucessMsgData(eduExperience);
    }


    @ApiIgnore
    @PostMapping("detailByUserResumeId")
    public Map<String,Object> detailByUserResumeId(@RequestParam @NotNull Long userResumeId) {
        if(userResumeId==null){
            return Result.retrunFail();
        }else{
            EduExperience eduExperience=new EduExperience();
            eduExperience.setUserResumeId(userResumeId);
            List<EduExperience> eduList=eduExperienceService.queryListByWhere(eduExperience);
            return Result.retrunSucessMsgData(eduList);
        }

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
