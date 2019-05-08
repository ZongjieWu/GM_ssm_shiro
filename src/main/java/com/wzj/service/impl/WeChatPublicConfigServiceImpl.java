package com.wzj.service.impl;

import com.wzj.dao.mapper.WeChatPublicConfigMapper;
import com.wzj.model.WeChatPublicConfig;
import com.wzj.service.service.WeChatPublicConfigService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/04/02.
 */
@Service
public class WeChatPublicConfigServiceImpl extends AbstractService<WeChatPublicConfig> implements WeChatPublicConfigService {

    @Autowired
    private WeChatPublicConfigMapper weChatPublicConfigMapper;

}
