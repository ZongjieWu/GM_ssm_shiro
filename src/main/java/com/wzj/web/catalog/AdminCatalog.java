package com.wzj.web.catalog;

import com.wzj.enums.Result;
import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class AdminCatalog {
    @Autowired
    private AdminService adminService;

    @GetMapping("logout")
    public String logout(HttpSession session){
        Map<String,Object> map=new HashMap<String,Object>();
        session.setAttribute("admin",null);
        return "WEB-INF/views/admin/login";
    }

    /**
     *跳转至管理员信息
     * */
    @GetMapping("/jumpInfo")
    public String jumpInfo(HttpSession session){
        Admin a=(Admin)session.getAttribute("admin");
        if(a==null){
        }else{
            Long id=a.getId();
            Admin admin=adminService.findById(id);
            session.setAttribute("admin",admin);
        }
        return "WEB-INF/views/admin/admin/info";
    }
    /**
     *跳转至登入页
     * */
    @GetMapping("/jumpLogin")
    public String jumpLogin(){
        return "WEB-INF/views/admin/login";
    }
    /**
     *跳转至登入页
     * */
    @GetMapping("/jumpIndex")
    public String jumpIndex(){
        return "WEB-INF/views/admin/index";
    }
    /**
     *跳转至控制台
     * */
    @GetMapping("/jumpConsole")
    public String jumpConsole(){
        return "WEB-INF/views/admin/console";
    }
    /**
     *跳转至忘记密码页
     * */
    @GetMapping("/jumpForget")
    public String jumpForget(){
        return "WEB-INF/views/admin/forget";
    }
    /**
     *跳转至注册页面
     * */
    @GetMapping("/jumpRegister")
    public String jumpRegister(){
        return "WEB-INF/views/admin/register";
    }
}
