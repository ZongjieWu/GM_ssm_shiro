package com.wzj.service.impl;

import com.wzj.dao.mapper.IssueJobMapper;
import com.wzj.model.IssueJob;
import com.wzj.service.service.IssueJobService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@Service
public class IssueJobServiceImpl extends AbstractService<IssueJob> implements IssueJobService {

    @Autowired
    private IssueJobMapper issueJobMapper;

    @Override
    public Map<String, Object> apiDetail(Long id) {
        return issueJobMapper.apiDetail(id);
    }
}
