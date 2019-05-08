package com.wzj.service.service;
import com.wzj.model.IssueJob;
import com.wzj.service.Service;

import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/04/01.
 */
public interface IssueJobService extends Service<IssueJob> {
    Map<String,Object> apiDetail(Long id);
}
