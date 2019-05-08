package com.wzj.web.catalog;

import com.wzj.model.UserResume;
import com.wzj.service.service.UserResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/resume/")
public class UserResumeCatalog {
    @Autowired
    UserResumeService userResumeService;
    /**
     *跳转用户简历分页
     * */
    @GetMapping("userResume/jumpPaging")
    public String jumpUserResumePaging(){
        return "WEB-INF/views/admin/resume/userResume/paging";
    }

    /**
     *跳转详情
     * */
    @GetMapping("userResume/jumpDetail")
    public String jumpUserResumeDetail(Long id, HttpServletRequest request){
        UserResume userResume=userResumeService.findById(id);
        request.setAttribute("userResume",userResume);
        return "WEB-INF/views/admin/resume/userResume/detail";
    }


    /**
     *跳转发送简历分页
     * */
    @GetMapping("sendResume/jumpPaging")
    public String jumpSendResumePaging(){
        return "WEB-INF/views/admin/resume/sendResume/paging";
    }
    /**
     *跳转发送简历分页
     * */
    @GetMapping("sendResume/jumpDetail")
    public String jumpSendResumejumpDetail(){
        return "WEB-INF/views/admin/resume/sendResume/detail";
    }

}
