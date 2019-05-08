package com.wzj.dao.mapper;

import com.wzj.dao.MyMapper;
import com.wzj.model.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EnterpriseMapper extends MyMapper<Enterprise> {
    Map<String,Object> login(@Param("phone") String phone, @Param("pwd") String pwd);
}