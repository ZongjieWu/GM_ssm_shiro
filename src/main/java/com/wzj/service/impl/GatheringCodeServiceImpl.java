package com.wzj.service.impl;

import com.wzj.dao.mapper.GatheringCodeMapper;
import com.wzj.model.GatheringCode;
import com.wzj.service.service.GatheringCodeService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/04/24.
 */
@Service
public class GatheringCodeServiceImpl extends AbstractService<GatheringCode> implements GatheringCodeService {

    @Autowired
    private GatheringCodeMapper gatheringCodeMapper;

}
