package com.wzj.service.service;
import com.github.pagehelper.PageInfo;
import com.wzj.model.SendResume;
import com.wzj.service.Service;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
public interface SendResumeService extends Service<SendResume> {
    PageInfo<Map<String,Object>> pagingByEnterpriseId(String sortName, Integer page, Integer limit,String keywords,Long id);
    PageInfo<Map<String,Object>> paging(String sortName, Integer page, Integer limit,String keywords,Long uid);
    String queryLastSendTime(Long uid,Long issueJobId);
}
