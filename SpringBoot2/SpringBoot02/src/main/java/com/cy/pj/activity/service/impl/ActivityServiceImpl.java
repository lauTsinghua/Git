package com.cy.pj.activity.service.impl;

import com.cy.pj.activity.dao.ActivityDao;
import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl implements ActivityService {
   private static final Logger log = //获取该类日志的实现
           LoggerFactory.getLogger(ActivityServiceImpl.class);
    @Autowired
    private ActivityDao activityDao ;

    @Override
    public List<Activity> findActivitys() {
        log.info("start:{}",System .currentTimeMillis() ) ;
        List<Activity> list = activityDao.findActivitys();
        log.info("end:{}",System .currentTimeMillis() ) ;
        return list;
    }
}
