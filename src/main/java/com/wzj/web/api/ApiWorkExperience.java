package com.wzj.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedHashTreeMap;
import com.wzj.enums.Result;
import com.wzj.model.UserResume;
import com.wzj.model.WorkExperience;
import com.wzj.service.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/08.
 */
@ApiIgnore
@RestController
@RequestMapping("/api/workExperience/")
public class ApiWorkExperience {

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
    public Map<String,Object> update(String workStrList) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gson=new Gson();
        List<Object> workExperienceList=(List<Object>)gson.fromJson(workStrList,Object.class);
        LinkedHashTreeMap map= new LinkedHashTreeMap();
        WorkExperience workExperience=null;
        for(int i=0,count=workExperienceList.size();i<count;i++){
            map=(LinkedHashTreeMap) workExperienceList.get(i);
            workExperience=new WorkExperience();
            workExperience.setUserResumeId(Long.valueOf(map.get("userResumeId").toString().split("[.]")[0]));
            workExperience.setEnterpriseName(map.get("enterpriseName").toString());
            workExperience.setJobName(map.get("jobName").toString());
            workExperience.setStartTime(map.get("startTime").toString());
            workExperience.setEndTime(map.get("endTime").toString());
            workExperience.setWorkContent(map.get("workContent").toString());
            if(map.get("id")==null||map.get("id").toString().equals("")){
                workExperience.setAddTime(simpleDateFormat.format(new Date()));
                workExperienceService.save(workExperience);
            }else{
                workExperience.setId(Long.valueOf(map.get("id").toString()));
                workExperience.setModifyTime(simpleDateFormat.format(new Date()));
                WorkExperience e=new WorkExperience();
                e.setUserResumeId(e.getUserResumeId());
                List<WorkExperience> eduExperienceList1= workExperienceService.queryListByWhere(e);
                for(int j=0,jcount=eduExperienceList1.size();j<jcount;j++){
                    if(eduExperienceList1.get(j).getId()==workExperience.getId()){
                        workExperienceService.update(workExperience);
                    }
                }
            }
        }

	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detailByUserResumeId")
    public Map<String,Object> detailByUserResumeId(@RequestParam Long userResumeId) {
        if(userResumeId==null){
            return Result.retrunFail();
        }else{
            WorkExperience workExperience=new WorkExperience();
            workExperience.setUserResumeId(userResumeId);
            List<WorkExperience> weList=workExperienceService.queryListByWhere(workExperience);
            return Result.retrunSucessMsgData(weList);
        }

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
