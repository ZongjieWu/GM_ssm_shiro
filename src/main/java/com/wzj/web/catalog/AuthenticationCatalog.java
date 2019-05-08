package com.wzj.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication/")
public class AuthenticationCatalog {
    /**
     *跳转用户分页
     * */
    @GetMapping("user/jumpPaging")
    public String jumpUserPaging(){
        return "WEB-INF/views/admin/authentication/user/paging";
    }

    /**
     *跳转到企业分页
     * */
    @GetMapping("enterprise/jumpPaging")
    public String JumpEnterprisePaging(){
        return "WEB-INF/views/admin/authentication/enterprise/paging";
    }



    /**
     *跳转到企业分页
     * */
    @GetMapping("remit/jumpPaging")
    public String JumpRemitPaging(){
        return "WEB-INF/views/admin/authentication/remit/paging";
    }
}
