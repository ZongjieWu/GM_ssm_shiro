package com.wzj.service.impl;

import com.wzj.dao.mapper.UserResumeMapper;
import com.wzj.model.UserResume;
import com.wzj.service.service.UserResumeService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/03/30.
 */
@Service
public class UserResumeServiceImpl extends AbstractService<UserResume> implements UserResumeService {

    @Autowired
    private UserResumeMapper userResumeMapper;

}
