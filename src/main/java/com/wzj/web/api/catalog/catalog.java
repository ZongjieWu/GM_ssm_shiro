package com.wzj.web.api.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weixin/weChatPublic")
public class catalog {
    @GetMapping("jumpFindJob")
    public String jumpFindJob(){
        return "WEB-INF/views/weChatPublic/findJob";
    }
}
