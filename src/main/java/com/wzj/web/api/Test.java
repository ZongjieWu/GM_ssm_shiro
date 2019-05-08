package com.wzj.web.api;

import com.wzj.model.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/shiroTest/")
public class Test {
   @PostMapping("aquaireSessionName")
   public Map<String,Object> aquaireSessionName(){
       Subject subject = SecurityUtils.getSubject();
       Session session = subject.getSession();
       Map<String,Object> map=new HashMap<>();
       Map<String,Object> dataMap=new HashMap<>();
       List<Object> sessionCollects=(List<Object>)session.getAttributeKeys();
       List<String> sessionList=new ArrayList<>();
       String str=null;
       for(int i=0,count=sessionCollects.size();i<count;i++){
           str=(String)sessionCollects.get(i);
           sessionList.add(str);
       }
       Object object=session.getAttribute(sessionList.get(0));
       dataMap.put("admin",object);
       dataMap.put("sessionKeys",sessionCollects);
       dataMap.put("sessionList",sessionList);
       dataMap.put("sessionId",session.getId());
       map.put("code",0);
       map.put("msg","成功");
       map.put("data",dataMap);
       return map;
   }
}
