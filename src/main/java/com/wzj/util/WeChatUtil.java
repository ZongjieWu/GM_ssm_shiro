package com.wzj.util;

import com.google.gson.Gson;
import com.wzj.model.WeChatPublicConfig;
import com.wzj.service.service.WeChatPublicConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

public class WeChatUtil {
    //private static String token = ConfigUtil.getProperty("wx_token");
    private static String token = "s3452sfssdfasdfasdf";

    private static String do_main="jxhuadun.cn";

    private static String template_id="u9umq2mQ9NESb_9kPUmMqq-0p4rdgVRQxNBPO-P9RD4";

    @Autowired
    private WeChatPublicConfigService weChatPublicConfigServiceService;
    /**
     * 验证签名的方法
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);
        // 1. 将token、timestamp、nonce三个参数进行字典序排序
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // 2.将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
        // 3. 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return temp.equals(signature);
    }

    public static String aquireAccessToken(String appId,String appSerect) {
        String result="" +
                "";
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+appSerect;
        try {
            result = HttpClientManager.getUrlData(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String menuDataConfig() {
        //封装用户的菜单
        Map<String,Object> userSubButtonParamMap1=new HashMap<>();
        userSubButtonParamMap1.put("type","view");
        userSubButtonParamMap1.put("name","找工作");
        userSubButtonParamMap1.put("url","http://"+do_main+"/weChatPublic/jobList.html");
//        Map<String,Object> userSubButtonParamMap2=new HashMap<>();
//        userSubButtonParamMap2.put("type","view");
//        userSubButtonParamMap2.put("name","更新简历");
//        userSubButtonParamMap2.put("url","http://www.baidu.com");
        Map<String,Object> userSubButtonParamMap3=new HashMap<>();
        userSubButtonParamMap3.put("type","view");
        userSubButtonParamMap3.put("name","面试通知");
        userSubButtonParamMap3.put("url","http://"+do_main+"/weChatPublic/interviewNotify.html");
        Map<String,Object> userSubButtonParamMap4=new HashMap<>();
        userSubButtonParamMap4.put("type","view");
        userSubButtonParamMap4.put("name","投递记录");
        userSubButtonParamMap4.put("url","http://"+do_main+"/weChatPublic/tdjl.html");

        List<Map<String,Object>> userButtonMapList=new ArrayList<>();
        userButtonMapList.add(userSubButtonParamMap1);
//        userButtonMapList.add(userSubButtonParamMap2);
        userButtonMapList.add(userSubButtonParamMap3);
        userButtonMapList.add(userSubButtonParamMap4);
        Map<String,Object> userButtonMap=new HashMap<>();
        userButtonMap.put("name","教师个人服务");
        userButtonMap.put("sub_button",userButtonMapList);



        //封装企业的菜单
        Map<String,Object> enterpriseSubButtonParamMap1=new HashMap<>();
        enterpriseSubButtonParamMap1.put("type","view");
        enterpriseSubButtonParamMap1.put("name","查收简历");
        enterpriseSubButtonParamMap1.put("url","http://"+do_main+"/weChatPublic/enterprise/receiveResume.html");
        Map<String,Object> enterpriseSubButtonParamMap2=new HashMap<>();
        enterpriseSubButtonParamMap2.put("type","view");
        enterpriseSubButtonParamMap2.put("name","搜索简历");
        enterpriseSubButtonParamMap2.put("url","http://"+do_main+"/weChatPublic/enterprise/findResume.html");
        Map<String,Object> enterpriseSubButtonParamMap3=new HashMap<>();
        enterpriseSubButtonParamMap3.put("type","view");
        enterpriseSubButtonParamMap3.put("name","发布职位");
        enterpriseSubButtonParamMap3.put("url","http://"+do_main+"/weChatPublic/enterprise/jobList.html");
        List<Map<String,Object>> enterpriseButtonMapList=new ArrayList<>();
        enterpriseButtonMapList.add(enterpriseSubButtonParamMap1);
        enterpriseButtonMapList.add(enterpriseSubButtonParamMap2);
        enterpriseButtonMapList.add(enterpriseSubButtonParamMap3);
        Map<String,Object> enterpriseButtonMap=new HashMap<>();
        enterpriseButtonMap.put("name","企业招聘服务");
        enterpriseButtonMap.put("sub_button",enterpriseButtonMapList);

        List<Map<String,Object>> mapList=new ArrayList<>();
        mapList.add(userButtonMap);
        mapList.add(enterpriseButtonMap);
        Map<String,Object> map=new HashMap<>();
        map.put("button",mapList);
        Gson gson=new Gson();
        return gson.toJson(map);
    }

    public static String interviewNotifyPush(WeChatPublicConfig weChatPublicConfig,Map<String,Object> map){
        System.out.println("weChatPublicConfig.getAccessToken()"+weChatPublicConfig.getAccessToken());
        String result="";
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+weChatPublicConfig.getAccessToken();
        try {
            result = HttpClientManager.postUrlData(url,WeChatUtil.interviewNotifyPushConfig(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String interviewNotifyPushConfig(Map<String,Object> param){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("touser",param.get("openid"));
        paramMap.put("template_id",template_id);
        paramMap.put("url","http://"+do_main+"/weChatPublic/interviewNotify.html");
        Map<String,Object> paramDataMap=new HashMap<>();
        Map<String,Object> notifyDate=new HashMap<>();
        notifyDate.put("value",param.get("notifyDate"));
        notifyDate.put("color","#173177");
        paramDataMap.put("first",notifyDate);
        Map<String,Object> enterpriseName=new HashMap<>();
        enterpriseName.put("value",param.get("enterpriseName"));
        enterpriseName.put("color","#173177");
        paramDataMap.put("keyword1",enterpriseName);
        Map<String,Object> jobName=new HashMap<>();
        jobName.put("value",param.get("jobName"));
        jobName.put("color","#173177");
        paramDataMap.put("keyword2",jobName);
        Map<String,Object> content=new HashMap<>();
        content.put("value",param.get("content"));
        content.put("color","#173177");
        paramDataMap.put("remark",content);
//        Map<String,Object> concatPhone=new HashMap<>();
//        concatPhone.put("value",param.get("concatPhone"));
//        concatPhone.put("color","#173177");
//        paramDataMap.put("concatPhone",concatPhone);
        Map<String,Object> interviewTime=new HashMap<>();
        interviewTime.put("value",param.get("interviewTime"));
        interviewTime.put("color","#173177");
        paramDataMap.put("keyword3",interviewTime);
        paramMap.put("data",paramDataMap);
        Gson gson=new Gson();
        return gson.toJson(paramMap);
    }
}
