package com.wzj.service.impl;

import com.wzj.dao.mapper.EduExperienceMapper;
import com.wzj.model.EduExperience;
import com.wzj.service.service.EduExperienceService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/04/09.
 */
@Service
public class EduExperienceServiceImpl extends AbstractService<EduExperience> implements EduExperienceService {

    @Autowired
    private EduExperienceMapper eduExperienceMapper;

}
