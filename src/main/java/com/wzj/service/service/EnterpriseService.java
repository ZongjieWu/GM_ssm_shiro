package com.wzj.service.service;
import com.wzj.model.Enterprise;
import com.wzj.service.Service;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/11.
 */
public interface EnterpriseService extends Service<Enterprise> {
    Map<String,Object> login(String phone, String pwd);
}
