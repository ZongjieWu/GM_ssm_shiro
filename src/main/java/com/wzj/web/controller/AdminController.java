package com.wzj.web.controller;
import com.wzj.enums.Result;
import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/03.
 */
@ApiIgnore
@Validated
@RestController
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public Map<String,Object> login(@NotNull @NotEmpty String phone, @NotNull @NotEmpty  String pwd, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(phone, pwd));
        Map<String,Object> map=new HashMap<String,Object>();
        Admin admin=new Admin();
        admin.setPhone(phone);
        admin.setPwd(pwd);
        Admin a=adminService.findOne(admin);
        if(a==null){
            return Result.retrunFail();
        }else{
            session.setAttribute("admin",a);
            return Result.retrunSucess();
        }
    }


    @RequestMapping("add")
    public Map<String,Object> add(Admin admin) {
        try {
            adminService.save(admin);
            return Result.retrunSucess();
        }catch (Exception e){
            return Result.retrunFail();
        }
    }

    @RequestMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    adminService.deleteById(id);
	    return Result.retrunSucess();
    }

    @RequestMapping("update")
    public Map<String,Object> update(Admin admin) {
        try {
            adminService.update(admin);
            return Result.retrunSucess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.retrunFail();
        }
    }

    @RequestMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        Admin admin = adminService.findById(id);
        return Result.retrunSucessMsgData(admin);
    }

    @RequestMapping("paging")
    public Map<String,Object> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Admin> list = adminService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map=Result.retrunSucessMsgData(pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
