package com.wzj.web.shiro;

import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
@Component
public class ShiroRealm extends AuthorizingRealm{

    //后台用户
    @Autowired
    private AdminService adminService;

//    @Autowired
//    private IRole roleService;
//
//    @Autowired
//    private IPermission permissionService;
//
//    @Autowired
//    HttpServletRequest request;


     /*
    * @param authenticationToken 包含用户名及密码的令牌对象，是由shiro传递过来的参数
    * @return
    * @throws AuthenticationException
    * */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String phone = (String)authenticationToken.getPrincipal();
        String password = String.valueOf((char[])authenticationToken.getCredentials());
        Admin a=new Admin();
        a.setPhone(phone);
        a.setPwd(password);
        //判断是否为后台登陆
        Admin admin=adminService.findOne(a);
        if(admin!=null){
            return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),authenticationToken.getCredentials(),"myReam");
        }
        return null;
    }
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("AuthorizationInfoAuthorizationInfoAuthorizationInfo");
//        System.out.println("AuthorizationInfoAuthorizationInfoAuthorizationInfo");
//        System.out.println("AuthorizationInfoAuthorizationInfoAuthorizationInfo");
//        System.out.println("AuthorizationInfoAuthorizationInfoAuthorizationInfo");
//        String phone = (String) principalCollection.getPrimaryPrincipal();
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        List<Role> roleList = roleService.findRoleByName(phone);
//        for (Role role : roleList) {
//            authorizationInfo.addRole(role.getName());
//        }
//        List<Permission> permissionList = permissionService.findPermissionByName(phone);
//        for (Permission permission : permissionList) {
//            authorizationInfo.addStringPermission(permission.getDescript());
//        }
        return null;
    }
}
