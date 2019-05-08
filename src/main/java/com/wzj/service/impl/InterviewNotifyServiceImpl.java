package com.wzj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.dao.mapper.InterviewNotifyMapper;
import com.wzj.model.InterviewNotify;
import com.wzj.service.service.InterviewNotifyService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@Service
public class InterviewNotifyServiceImpl extends AbstractService<InterviewNotify> implements InterviewNotifyService {

    @Autowired
    private InterviewNotifyMapper interviewNotifyMapper;

    @Override
    public PageInfo<InterviewNotify> paging(String sortName, Integer page, Integer limit,String keywords,Long uid) {
        PageHelper.orderBy(sortName);
        PageHelper.startPage(page,limit);
        List<Map<String,Object>> interviewNotifyList=interviewNotifyMapper.paging(keywords,uid);
        return new PageInfo(interviewNotifyList);
    }
    @Override
    public PageInfo<InterviewNotify> pagingByEnterpriseId(String sortName, Integer page, Integer limit,String keywords,Long enterpriseId) {
        PageHelper.orderBy(sortName);
        PageHelper.startPage(page,limit);
        List<Map<String,Object>> interviewNotifyList=interviewNotifyMapper.pagingByEnterpriseId(keywords,enterpriseId);
        return new PageInfo(interviewNotifyList);
    }

    @Override
    public Map<String, Object> detail(Long id) {
        return interviewNotifyMapper.detail(id);
    }
}
