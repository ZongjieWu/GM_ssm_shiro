package com.wzj.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remitRecord/")
public class RemitRecordCatalog {
    /**
     *跳转到企业分页
     * */
    @GetMapping("jumpRecordPaging")
    public String jumpRecordPaging(){
        return "WEB-INF/views/admin/remitRecord/paging";
    }

    @GetMapping("jumpUnPassPaging")
    public String jumpUnPassPaging(){
        return "WEB-INF/views/admin/remitRecord/unPassPaging";
    }
}
