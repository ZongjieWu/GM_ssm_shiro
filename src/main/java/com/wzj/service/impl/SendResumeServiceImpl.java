package com.wzj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzj.dao.mapper.SendResumeMapper;
import com.wzj.model.SendResume;
import com.wzj.service.service.SendResumeService;
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
public class SendResumeServiceImpl extends AbstractService<SendResume> implements SendResumeService {

    @Autowired
    private SendResumeMapper sendResumeMapper;

    @Override
    public PageInfo<Map<String, Object>> pagingByEnterpriseId(String sortName, Integer page, Integer limit,String keywords,Long id) {
        PageHelper.orderBy(sortName);
        PageHelper.startPage(page,limit);
        return new PageInfo<>(sendResumeMapper.pagingByEnterpriseId(keywords,id));
    }
    @Override
    public PageInfo<Map<String, Object>> paging(String sortName, Integer page, Integer limit,String keywords,Long uid) {
        PageHelper.orderBy(sortName);
        PageHelper.startPage(page,limit);
        return new PageInfo<>(sendResumeMapper.paging(keywords,uid));
    }
    @Override
    public String queryLastSendTime(Long uid,Long issueJobId) {
        return sendResumeMapper.queryLastSendTime(uid,issueJobId);
    }

}
