package com.wzj.web.quartz;

import com.google.gson.Gson;
import com.wzj.model.WeChatPublicConfig;
import com.wzj.service.service.WeChatPublicConfigService;
import com.wzj.util.WeChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@ApiIgnore
@Component
@Lazy(value=false)
public class RefreshAccessToken {
    private static Logger logger = LoggerFactory.getLogger(RefreshAccessToken.class);
    @Autowired
    private WeChatPublicConfigService weChatPublicConfigService;
    /**
     * 两个小时刷新一次
     * */
    @Scheduled(fixedDelay=1000*60*60*2)
    public void refreshAccessToken(){
        Gson gson=new Gson();
        WeChatPublicConfig weChatPublicConfig = weChatPublicConfigService.findById(1L);
        String accessStr=WeChatUtil.aquireAccessToken(weChatPublicConfig.getAppId(),weChatPublicConfig.getAppSecret());
        Map<String,Object> map=gson.fromJson(accessStr,Map.class);
        weChatPublicConfig.setAccessToken(map.get("access_token").toString());
        System.out.println(map.get("access_token").toString());
        weChatPublicConfigService.update(weChatPublicConfig);
    }
}
