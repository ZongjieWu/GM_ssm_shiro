package com.wzj.service.impl;

import com.wzj.dao.mapper.UserMapper;
import com.wzj.model.User;
import com.wzj.service.service.UserService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/28.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(String phone, String pwd) {
        return userMapper.login(phone,pwd);
    }
}
