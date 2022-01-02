package com.cy.service.impl;

import com.cy.dao.ActivityDao;
import com.cy.pojo.ActivityPojo;
import com.cy.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Slf4j
@Service
public class ActivityServiceImpl implements ActivityService  {
    @Autowired
    private ActivityDao activityDao ;
    @Override
    public List<ActivityPojo> findAll() {
        List<ActivityPojo> list = activityDao.findAll();
        return list;
    }
}
