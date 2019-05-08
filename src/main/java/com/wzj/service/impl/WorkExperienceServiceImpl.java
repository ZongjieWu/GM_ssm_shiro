package com.wzj.service.impl;

import com.wzj.dao.mapper.WorkExperienceMapper;
import com.wzj.model.WorkExperience;
import com.wzj.service.service.WorkExperienceService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/04/08.
 */
@Service
public class WorkExperienceServiceImpl extends AbstractService<WorkExperience> implements WorkExperienceService {

    @Autowired
    private WorkExperienceMapper workExperienceMapper;

}
