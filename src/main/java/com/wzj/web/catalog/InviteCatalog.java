package com.wzj.web.catalog;

import com.wzj.model.InterviewNotify;
import com.wzj.model.IssueJob;
import com.wzj.model.UserResume;
import com.wzj.service.service.InterviewNotifyService;
import com.wzj.service.service.IssueJobService;
import com.wzj.service.service.UserResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/invite/")
public class InviteCatalog {
    @Autowired
    IssueJobService issueJobService;
    @Autowired
    InterviewNotifyService interviewNotifyService;
    /**
     *跳转发布职位分页
     * */
    @GetMapping("issueJob/jumpPaging")
    public String jumpIssueJobPaging(){
        return "WEB-INF/views/admin/invite/issueJob/paging";
    }
    /**
     *跳转发布职位分页
     * */
    @GetMapping("issueJob/jumpDetail")
    public String jumpIssueJobDetail(Long id,HttpServletRequest request){
        IssueJob issueJob=issueJobService.findById(id);
        request.setAttribute("issueJob",issueJob);
        return "WEB-INF/views/admin/invite/issueJob/detail";
    }

    /**
     *跳转发布职位分页
     * */
    @GetMapping("interviewNotify/jumpPaging")
    public String jumpInterviewNotifyPaging(){
        return "WEB-INF/views/admin/invite/interviewNotify/paging";
    }
    /**
     *跳转发布职位分页
     * */
    @GetMapping("interviewNotify/jumpDetail")
    public String jumpInterviewNotifyDetail(Long id,HttpServletRequest request){
        Map<String,Object> interviewNotifyMap=interviewNotifyService.detail(id);
        request.setAttribute("interviewNotify",interviewNotifyMap);
        return "WEB-INF/views/admin/invite/interviewNotify/detail";
    }

}
