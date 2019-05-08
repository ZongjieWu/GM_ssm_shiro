package com.wzj.web.api;

import com.github.pagehelper.PageInfo;
import com.wzj.enums.Result;
import com.wzj.model.User;
import com.wzj.model.UserResume;
import com.wzj.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/28.
 */
@Api(tags="用户管理")
@Validated
@RestController
@RequestMapping("/api/user/")
public class ApiUser {

    @Autowired
    UserService userService;

    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(User user) {
        //判断用户电话号码是否注册过
        User u=new User();
        u.setPhone(user.getPhone());
        List<User> list=userService.queryListByWhere(u);
        if(list==null||list.size()==0){
        }else{
            return Result.retrunFailMsg("手机号码不能重复注册");
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setAddTime(simpleDateFormat.format(new Date()));
        user.setModifyTime(simpleDateFormat.format(new Date()));
        userService.save(user);
        User udata=userService.findOne(u);
        udata.setPwd(null);
        return Result.retrunSucessMsgData(udata);
    }

    @ApiOperation("用户登入")
    @RequestMapping("login")
    public Map<String,Object> login(String phone,String pwd) {
        User user=new User();
        user.setPhone(phone);
        user.setPwd(pwd);
        Map<String,Object> userMap=userService.login(phone,pwd);
        if(userMap==null){
            return Result.retrunFailMsg("用户名或密码错误");
        }else if(Integer.valueOf(userMap.get("status").toString())==3){
            return Result.retrunFailMsg("账号已冻结");
        }else{
            userMap.put("pwd",null);
            return Result.retrunSucessMsgData(userMap);
        }

    }
    @ApiIgnore
    @PostMapping("updatePwd")
    public Map<String,Object> update(Long id,String oldPwd,String newPwd) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user=userService.findById(id);
        if(user.getPwd().equals(oldPwd)){
            user.setPwd(newPwd);
            user.setModifyTime(simpleDateFormat.format(new Date()));
            userService.update(user);
            return Result.retrunSucess();
        }else{
            return Result.retrunFailMsg("旧密码不正确");
        }
    }

    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(User user) {
        if(user.getId()==null){
            return Result.retrunFail();
        }else{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setModifyTime(simpleDateFormat.format(new Date()));
            userService.update(user);
            User u=userService.findById(user.getId());
            return Result.retrunSucessMsgData(u);
        }
    }
    @ApiIgnore
    @PostMapping("batchAuthentication")
    public Map<String,Object> update(String ids,Integer authenticationStatus) {
            String[] idsArr=ids.split(",");
            User user=null;
            for(int i=0;i<idsArr.length;i++){
                user.setId(Long.valueOf(idsArr[0]));
                user.setAuthenticationStatus(authenticationStatus);
                userService.update(user);
            }
            return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("authentication")
    public Map<String,Object> authentication(User user) {
        if(user.getId()==null){
            return Result.retrunFail();
        }else{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setModifyTime(simpleDateFormat.format(new Date()));
            if(user==null||user.getStatus()==null){
            }else if(user.getStatus()==2){
                user.setAuthenticationTime(simpleDateFormat.format(new Date()));
            }
            userService.update(user);
            User u=userService.findById(user.getId());
            return Result.retrunSucessMsgData(u);
        }
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        User user = userService.findById(id);
        return Result.retrunSucessMsgData(user);
    }

    @ApiIgnore
    @PostMapping("refreshByPhone")
    public Map<String,Object> refreshByPhone(@RequestParam String phone) {
        User user=userService.findBy("phone",phone);
        return Result.retrunSucessMsgData(user);
    }

}
