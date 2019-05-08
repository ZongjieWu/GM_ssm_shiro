package com.wzj.dao.mapper;

import com.wzj.dao.MyMapper;
import com.wzj.model.SendResume;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SendResumeMapper extends MyMapper<SendResume> {
    List<Map<String,Object>> pagingByEnterpriseId(@Param("keywords") String keywords,@Param("id")Long id);
    List<Map<String,Object>> paging(@Param("keywords") String keywords,@Param("uid")Long uid);
    String queryLastSendTime(@Param("uid") Long uid,@Param("issueJobId")Long issueJobId);
}