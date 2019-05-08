package com.wzj.service.service;
import com.wzj.model.User;
import com.wzj.service.Service;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/28.
 */
public interface UserService extends Service<User> {
    Map<String,Object> login(String phone, String pwd);
}
