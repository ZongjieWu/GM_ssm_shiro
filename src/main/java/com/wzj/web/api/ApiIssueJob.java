package com.wzj.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.enums.Result;
import com.wzj.model.Enterprise;
import com.wzj.model.IssueJob;
import com.wzj.service.service.EnterpriseService;
import com.wzj.service.service.IssueJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@Validated
@Api(tags="发布职位")
@RestController
@RequestMapping("/api/issueJob/")
public class ApiIssueJob {

    @Autowired
    private IssueJobService issueJobService;
    @Autowired
    private EnterpriseService enterpriseService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(IssueJob issueJob) {
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
        if(issueJob.getId()==null){
            issueJob.setAddTime(simpleDateFormat.format(new Date()));
            issueJob.setModifyTime(simpleDateFormat.format(new Date()));
            issueJobService.save(issueJob);
        }else{
            issueJob.setModifyTime(simpleDateFormat.format(new Date()));
            issueJobService.update(issueJob);
        }
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam @NotNull Long id) {
        if(id==null){
            return Result.retrunFail();
        }else{
            Map<String,Object> issueJobMap = issueJobService.apiDetail(id);
            List<Map<String,Object>> issueJoblist=new ArrayList<>();
            issueJoblist.add(issueJobMap);
            return Result.retrunSucessMsgData(issueJoblist);
        }
    }

    @ApiIgnore
    @PostMapping("allByEnterpriseId")
    public Map<String,Object> allByEnterpriseId(@RequestParam @NotNull Long id) {
        if(id==null){
            return Result.retrunFail();
        }else{
            Example example=new Example(IssueJob.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("enterpriseId",id);
            criteria.andCondition(" (status=0 or status=1)");
            List<IssueJob> issueJoblist=issueJobService.queryListByWhereExample(example);
            return Result.retrunSucessMsgData(issueJoblist);
        }
    }

    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,String keywords,Long enterpriseId,String workPlace,String age,String sex,String workAge,String edu) {
        Example example=new Example(IssueJob.class);
        Example.Criteria criteria=example.createCriteria();
        if(enterpriseId==null){
        }else {
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//            Enterprise enterprise=enterpriseService.findById(enterpriseId);
//            try {
//                if(sdf.parse(enterprise.getServiceEndTime()).getTime()<sdf.parse(sdf.format(new Date())).getTime()){
//                    return Result.retrunFailMsgData("请续费后重新登入",-1);
//                }
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            criteria.andEqualTo("enterpriseId",enterpriseId);
        }
        if(enterpriseId==null){
        }else{
            criteria.andEqualTo("enterpriseId",enterpriseId);
        }
        if(keywords==null||keywords.equals("")){
        }else{
            criteria.andCondition(" (enterprise_name like '%"+keywords+"%' or job_name like '%"+keywords+"%')");
        }
        if(workPlace==null||workPlace.equals("")){
        }else{
            criteria.andCondition(" work_place like '%"+workPlace+"%'");
        }
        if(age==null||age.equals("")){
        }else{
            String[] ageArr=age.split("-");
            criteria.andCondition(" age between "+ageArr[0]+" and "+ageArr[1]);
        }
        if(workAge==null||workAge.equals("")){
        }else{
            String[] workAgeArr=workAge.split("-");
            criteria.andCondition(" work_age between "+workAgeArr[0]+" and "+workAgeArr[1]);
        }
        if(edu==null||edu.equals("")){
        }else{
            criteria.andCondition(" edu like '%"+edu+"%'");
        }
//        criteria.andCondition(" (status=0 or status=1)");
        PageHelper.startPage(page, limit);
        PageInfo<IssueJob> issueJobPageInfo = issueJobService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(issueJobPageInfo.getList());
        map.put("count",issueJobPageInfo.getTotal());
        return map;
    }
}
