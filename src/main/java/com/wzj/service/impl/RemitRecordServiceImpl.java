package com.wzj.service.impl;

import com.wzj.dao.mapper.RemitRecordMapper;
import com.wzj.model.RemitRecord;
import com.wzj.service.service.RemitRecordService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/04/26.
 */
@Service
public class RemitRecordServiceImpl extends AbstractService<RemitRecord> implements RemitRecordService {

    @Autowired
    private RemitRecordMapper remitRecordMapper;

}
