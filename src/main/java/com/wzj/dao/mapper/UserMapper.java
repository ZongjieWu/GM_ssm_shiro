package com.wzj.dao.mapper;

import com.wzj.dao.MyMapper;
import com.wzj.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper extends MyMapper<User> {
    Map<String,Object> login(@Param("phone")String phone, @Param("pwd")String pwd);
}