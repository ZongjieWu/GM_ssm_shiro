package com.wzj.web.shiro;

import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
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
//告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码,此处注释已在配置文件中配置
//    {
//        //设置用于匹配密码的CredentialsMatcher
//        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
//        hashMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
//        hashMatcher.setHashIterations(6);
//        this.setCredentialsMatcher(hashMatcher);
//    }


     /*
    * @param authenticationToken 包含用户名及密码的令牌对象，是由shiro传递过来的参数
    * @return
    * @throws AuthenticationException
    * */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String phone = (String)authenticationToken.getPrincipal();
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String phone = upToken.getUsername();
//        String password = String.valueOf((char[])authenticationToken.getCredentials());
        Admin a=new Admin();
        a.setPhone(phone);

        Admin admin=adminService.findOne(a);

        if(admin!=null){
            SimpleAuthenticationInfo sai=new SimpleAuthenticationInfo(admin,admin.getPwd(),ByteSource.Util.bytes(admin.getSalt()),getName());
            return sai;
        }else{
            return null;
        }
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
