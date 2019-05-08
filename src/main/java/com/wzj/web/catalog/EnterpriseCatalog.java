package com.wzj.web.catalog;

import com.wzj.model.Enterprise;
import com.wzj.service.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/enterprise/")
public class EnterpriseCatalog {
    @Autowired
    private EnterpriseService enterpriseService;


    /**
     *跳转认证未通过用户分页
     * */
    @GetMapping("jumpFrostPaging")
    public String jumpFrostPaging(){
        return "WEB-INF/views/admin/enterprise/frostPaging";
    }
    /**
     *跳转认证未通过用户分页
     * */
    @GetMapping("jumpUnPassPaging")
    public String jumpUnPassPaging(){
        return "WEB-INF/views/admin/enterprise/unPassPaging";
    }
    /**
     *跳转到企业分页
     * */
    @GetMapping("jumpPaging")
    public String jumpPaging(){
        return "WEB-INF/views/admin/enterprise/paging";
    }

    /**
     *跳转修改
     * */
    @GetMapping("jumpUpdate")
    public String jumpUpdate(Long id, HttpServletRequest request){
        Enterprise enterprise=enterpriseService.findById(id);
        request.setAttribute("enterprise",enterprise);
        return "WEB-INF/views/admin/enterprise/update";
    }

    /**
     *跳转详情
     * */
    @GetMapping("jumpDetail")
    public String jumpDetail(Long id, HttpServletRequest request){
        Enterprise enterprise=enterpriseService.findById(id);
        request.setAttribute("enterprise",enterprise);
        return "WEB-INF/views/admin/enterprise/detail";
    }
}
