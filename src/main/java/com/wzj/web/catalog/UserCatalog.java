package com.wzj.web.catalog;

import com.wzj.model.User;
import com.wzj.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/")
public class UserCatalog {
    @Autowired
    private UserService userService;
    /**
     *跳转认证未通过用户分页
     * */
    @GetMapping("jumpFrostPaging")
    public String jumpFrostPaging(){
        return "WEB-INF/views/admin/user/frostPaging";
    }
    /**
     *跳转认证未通过用户分页
     * */
    @GetMapping("jumpUnPassPaging")
    public String jumpUnPassPaging(){
        return "WEB-INF/views/admin/user/unPassPaging";
    }
    /**
     *跳转用户分页
     * */
    @GetMapping("jumpPaging")
    public String jumpPaging(){
        return "WEB-INF/views/admin/user/paging";
    }
    /**
     *跳转修改
     * */
    @GetMapping("jumpUpdate")
    public String jumpUpdate(Long id, HttpServletRequest request){
        User user=userService.findById(id);
        request.setAttribute("user",user);
        return "WEB-INF/views/admin/user/update";
    }

    /**
     *跳转详情
     * */
    @GetMapping("jumpDetail")
    public String jumpDetail(Long id, HttpServletRequest request){
        User user=userService.findById(id);
        request.setAttribute("user",user);
        return "WEB-INF/views/admin/user/detail";
    }
    /**
     *跳转普通用户
     * */
    @GetMapping("jumpGeneralPaging")
    public String jumpGeneralPaging(){
        return "WEB-INF/views/admin/user/generalPaging";
    }
}
