package com.wzj.service.impl;

import com.wzj.dao.mapper.EnterSetMapper;
import com.wzj.model.EnterSet;
import com.wzj.service.service.EnterSetService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
@Service
public class EnterSetServiceImpl extends AbstractService<EnterSet> implements EnterSetService {

    @Autowired
    private EnterSetMapper enterSetMapper;

}
