package com.wzj.web.controller;
import com.wzj.model.User;
import com.wzj.service.service.UserService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/28.
 */
@Api(tags="用户管理")
@Validated
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("add")
    public Map<String,Object> add(@RequestBody @ApiParam("用户") User user) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setAddTime(simpleDateFormat.format(new Date()));
        user.setModifyTime(simpleDateFormat.format(new Date()));
        userService.save(user);
        return Result.retrunSucess();
    }
    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    userService.deleteById(id);
	    return Result.retrunSucess();
    }
    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(User user) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setModifyTime(simpleDateFormat.format(new Date()));
        if(user==null||user.getStatus()==null){
        }else{
            user.setAuthenticationTime(simpleDateFormat.format(new Date()));
        }
	    userService.update(user);
	    return Result.retrunSucess();
    }
    @ApiIgnore
    @PostMapping("batchCheck")
    public Map<String,Object> update(String ids, Integer status) {
        User user=null;
        String[] idArr=ids.split(",");
        for(int i=0;i<idArr.length;i++){
            user=new User();
            user.setId(Long.valueOf(idArr[i]));
            user.setStatus(status);
            userService.update(user);
        }
        return Result.retrunSucess();
    }
    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        User user = userService.findById(id);
        return Result.retrunSucessMsgData(user);
    }
    @ApiIgnore
    @PostMapping("batchAuthentication")
    public Map<String,Object> batchAuthentication(String ids,Integer authenticationStatus) {
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
    @ApiOperation("分页")
    @PostMapping("paging")
    public Map<String,Object> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,Integer authenticationStatus,Integer status,String keywords) {
        Example example=new Example(User.class);
        Example.Criteria criteria=example.createCriteria();
        if(authenticationStatus==null){
        }else{
            criteria.andEqualTo("authenticationStatus",authenticationStatus);
        }
        if(keywords==null||keywords.trim().equals("")){
        }else{
            criteria.andCondition(" (name like '%"+keywords+"%' or phone like '%"+keywords+"%')");
        }
        if(status==null){
        }else {
            criteria.andEqualTo("status",status);
        }
        PageInfo<User> userPageInfo=userService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(userPageInfo.getList());
        map.put("count",userPageInfo.getTotal());
        return map;
    }
}
