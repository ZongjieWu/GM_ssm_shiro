package com.wzj.service.impl;

import com.wzj.dao.mapper.EnterpriseMapper;
import com.wzj.model.Enterprise;
import com.wzj.service.service.EnterpriseService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/11.
 */
@Service
public class EnterpriseServiceImpl extends AbstractService<Enterprise> implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public Map<String, Object> login(String phone, String pwd) {
        return enterpriseMapper.login(phone,pwd);
    }
}
