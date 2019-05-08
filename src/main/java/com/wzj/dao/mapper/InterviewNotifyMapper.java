package com.wzj.dao.mapper;

import com.wzj.dao.MyMapper;
import com.wzj.model.InterviewNotify;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InterviewNotifyMapper extends MyMapper<InterviewNotify> {
    List<Map<String,Object>> paging(@Param("keywords") String keywords,@Param("uid")Long uid);
    List<Map<String,Object>> pagingByEnterpriseId(@Param("keywords") String keywords,@Param("enterpriseId")Long enterpriseId);
    Map<String,Object> detail(Long id);
}