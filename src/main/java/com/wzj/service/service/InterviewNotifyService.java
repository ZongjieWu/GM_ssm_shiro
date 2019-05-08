package com.wzj.service.service;
import com.github.pagehelper.PageInfo;
import com.wzj.model.InterviewNotify;
import com.wzj.service.Service;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
public interface InterviewNotifyService extends Service<InterviewNotify> {
    PageInfo<InterviewNotify> paging(String sortName, Integer page, Integer limit,String keywords,Long enterpriseId);
    PageInfo<InterviewNotify> pagingByEnterpriseId(String sortName, Integer page, Integer limit,String keywords,Long enterpriseId);
    Map<String,Object> detail(Long id);
}
