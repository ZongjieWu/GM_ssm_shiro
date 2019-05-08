package com.wzj.web.api;

import com.google.gson.Gson;
import com.wzj.enums.Result;
import com.wzj.model.User;
import com.wzj.model.WeChatPublicConfig;
import com.wzj.service.service.UserService;
import com.wzj.service.service.WeChatPublicConfigService;
import com.wzj.util.HttpClientManager;
import com.wzj.util.WeChatUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/weixin/weChatPublic")
public class ApiWeChatPublic {
    private static String do_main="jxhuadun.cn";

    @Autowired
    private WeChatPublicConfigService weChatPublicConfigService;
    @Autowired
    private UserService userService;

    // 开发者接入验证 确认请求来自微信服务器
    @GetMapping("checkSignatureTest")
    public void checkSignatureTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        String echostr = request.getParameter("echostr");//成为开发者验证
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        PrintWriter out = response.getWriter();
        if (WeChatUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println("=======请求校验成功======" + echostr);
            out.print(echostr);
        }
        out.close();
        out = null;
    }

    @RequestMapping("loginInit")
    @ResponseBody
    public Map<String,Object> loginInit() {
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        //回调地址,要跟下面的地址能调通(getWechatGZAccessToken.do)
        String backUrl = "http://"+do_main+"/weixin/weChatPublic/aquireCode";
        /**
         *这儿一定要注意！！首尾不能有多的空格（因为直接复制往往会多出空格），其次就是参数的顺序不能变动
         **/
        //AuthUtil.APPID微信公众号的appId
        String url = null;
        try {
            url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + weChatPublicConfig.getAppId() +
                    "&redirect_uri=" + URLEncoder.encode(backUrl, "UTF-8") +
                    "&response_type=code" +
                    "&scope=snsapi_userinfo" +
                    "&state=STATE#wechat_redirect";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Result.retrunSucessMsgData(url);
    }

    @RequestMapping("aquireCode")
    public String aquireCode(HttpServletRequest request) throws Exception {
        String code = request.getParameter("code");
        return "redirect:http://"+do_main+"/weChatPublic/user.html?code="+code;
    }


    @RequestMapping("aquireUserInfo")
    @ResponseBody
    public Map<String,Object> aquireUserInfo(Long id,String code,HttpServletRequest request) throws Exception {
        User u=new User();
        u.setId(id);
        Gson gson = new Gson();
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        //微信公众号的APPID和APPSECRET
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + weChatPublicConfig.getAppId() +
                "&secret=" + weChatPublicConfig.getAppSecret() +
                "&code=" + code +
                "&grant_type=authorization_code";
        String result = HttpClientManager.getUrlData(url);
        Map<String, Object> data = gson.fromJson(result, Map.class);
        String openid = data.get("openid").toString();
        u.setWechatPublicOpenid(openid);
        userService.update(u);


        String token = data.get("access_token").toString();
        //获取信息
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token +
                "&openid=" + openid +
                "&lang=zh_CN";
        String infoResult = HttpClientManager.getUrlData(infoUrl);
        return Result.retrunSucessMsgData(infoResult);
    }

    @RequestMapping("queryMenu")
    @ResponseBody
    public String queryMenu(){
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        System.out.println("weChatPublicConfig.getAccessToken()"+weChatPublicConfig.getAccessToken());
        String result="";
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="+weChatPublicConfig.getAccessToken();
        try {
            result = HttpClientManager.getUrlData(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("aquireUserDefinedMenu")
    @ResponseBody
    public String aquireUserDefinedMenu(){
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        System.out.println("weChatPublicConfig.getAccessToken()"+weChatPublicConfig.getAccessToken());
        String result="";
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="+weChatPublicConfig.getAccessToken();
        try {
            result = HttpClientManager.getUrlData(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("createMenu")
    @ResponseBody
    public String createMenu(){
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        System.out.println("weChatPublicConfig.getAccessToken()"+weChatPublicConfig.getAccessToken());
        String result="";
        String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+weChatPublicConfig.getAccessToken();
        try {
            result = HttpClientManager.postUrlData(url,WeChatUtil.menuDataConfig());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("aquireAccessToken")
    @ResponseBody
    public String aquireAccessToken(){
        Gson gson=new Gson();
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        String accessStr=WeChatUtil.aquireAccessToken(weChatPublicConfig.getAppId(),weChatPublicConfig.getAppSecret());
        Map<String,Object> map=gson.fromJson(accessStr,Map.class);
        return map.get("access_token").toString();
    }


    @RequestMapping("interviewNotifyPush")
    @ResponseBody
    public String interviewNotifyPush(Map<String,Object> map){
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
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
}


