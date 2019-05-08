package com.wzj.service.impl;

import com.wzj.dao.mapper.JobTypeMapper;
import com.wzj.model.JobType;
import com.wzj.service.service.JobTypeService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/03/30.
 */
@Service
public class JobTypeServiceImpl extends AbstractService<JobType> implements JobTypeService {

    @Autowired
    private JobTypeMapper jobTypeMapper;

}
