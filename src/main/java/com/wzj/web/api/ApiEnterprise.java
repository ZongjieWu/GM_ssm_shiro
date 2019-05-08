package com.wzj.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.enums.Result;
import com.wzj.model.Enterprise;
import com.wzj.model.User;
import com.wzj.service.service.EnterpriseService;
import io.swagger.annotations.ApiOperation;
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
 * Created by Zongjie Wu on 2019/04/11.
 */
@ApiIgnore
@RestController
@RequestMapping("/api/enterprise/")
public class ApiEnterprise {

    @Autowired
    private EnterpriseService enterpriseService;

    @ApiOperation("企业登入")
    @RequestMapping("login")
    public Map<String,Object> login(String phone,String pwd) {
        Enterprise enterprise=new Enterprise();
        enterprise.setPhone(phone);
        enterprise.setPwd(pwd);
        Map<String,Object> enterMap=enterpriseService.login(phone,pwd);
        if(enterMap==null){
            return Result.retrunFailMsg("账号或者密码错误");
        }else if(enterMap.get("status")!=null&&Integer.valueOf(enterMap.get("status").toString())==3){
            return Result.retrunFailMsg("账号已冻结");
        }
        enterMap.put("pwd",null);
        return Result.retrunSucessMsgData(enterMap);
    }
    @ApiIgnore
    @PostMapping("add")
    public Map<String,Object> add(Enterprise enterprise) {
        //判断企业电话号码是否注册过
        Enterprise e=new Enterprise();
        e.setPhone(enterprise.getPhone());
        List<Enterprise> list=enterpriseService.queryListByWhere(e);
        if(list==null||list.size()==0){
        }else{
            return Result.retrunFailMsg("手机号码不能重复注册");
        }

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        enterprise.setAddTime(simpleDateFormat.format(new Date()));
        enterprise.setModifyTime(simpleDateFormat.format(new Date()));
        enterpriseService.save(enterprise);

        Enterprise edata=enterpriseService.findOne(e);
        edata.setPwd(null);
        return Result.retrunSucessMsgData(edata);
    }

    @ApiIgnore
    @PostMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    enterpriseService.deleteById(id);
	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("updatePwd")
    public Map<String,Object> update(Long id,String oldPwd,String newPwd) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Enterprise enterprise=enterpriseService.findById(id);
        if(enterprise.getPwd().equals(oldPwd)){
            enterprise.setPwd(newPwd);
            enterprise.setModifyTime(simpleDateFormat.format(new Date()));
            enterpriseService.update(enterprise);
            return Result.retrunSucess();
        }else{
            return Result.retrunFail();
        }
    }
    @ApiIgnore
    @PostMapping("update")
    public Map<String,Object> update(Enterprise enterprise) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        enterprise.setModifyTime(simpleDateFormat.format(new Date()));
        if(enterprise==null||enterprise.getStatus()==null){
        }else if(enterprise.getStatus()==1){
//            enterprise.setServiceEndTime(new Date());
            enterprise.setAuthenticationTime(simpleDateFormat.format(new Date()));
        }
	    enterpriseService.update(enterprise);

	    return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        Enterprise enterprise = enterpriseService.findById(id);
        return Result.retrunSucessMsgData(enterprise);
    }

    @ApiIgnore
    @PostMapping("batchAuthentication")
    public Map<String,Object> batchAuthentication(String ids,Integer authenticationStatus) {
        String[] idsArr=ids.split(",");
        Enterprise enterprise=null;
        for(int i=0;i<idsArr.length;i++){
            enterprise.setId(Long.valueOf(idsArr[0]));
            enterprise.setAuthenticationStatus(authenticationStatus);
            enterpriseService.update(enterprise);
        }
        return Result.retrunSucess();
    }

    @ApiIgnore
    @PostMapping("authentication")
    public Map<String,Object> authentication(Enterprise enterprise) {
        if(enterprise.getId()==null){
            return Result.retrunFail();
        }else{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            enterprise.setModifyTime(simpleDateFormat.format(new Date()));
            if(enterprise==null||enterprise.getStatus()==null){
            }else if(enterprise.getStatus()==2){
                enterprise.setAuthenticationTime(simpleDateFormat.format(new Date()));
            }
            enterpriseService.update(enterprise);
            Enterprise e=enterpriseService.findById(enterprise.getId());
            return Result.retrunSucessMsgData(e);
        }
    }


    @ApiIgnore
    @PostMapping("paging")
    public Map<String,Object> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        Example example=new Example(Enterprise.class);
        Example.Criteria criteria=example.createCriteria();
        PageHelper.startPage(page, limit);
        PageInfo<Enterprise> enterprisePageInfo = enterpriseService.queryPageListByWhereExample(" id desc",page,limit,example);
        Map<String,Object> map=Result.retrunSucessMsgData(enterprisePageInfo.getList());
        map.put("count",enterprisePageInfo.getTotal());
        return map;
    }
}
