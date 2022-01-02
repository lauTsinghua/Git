package com.cy.activity.service.impl;

import com.cy.activity.dao.ActivityDao;
import com.cy.activity.service.ActivityService;
import cy.activity.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public Activity findById(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("您输入的ID有误,请重新输入");
        }
        else {
            Activity activity = activityDao.findById(id);
            return activity ;
        }
    }

    @Override
    public List<Activity> findAll() {

        List<Activity> list = activityDao.findAll();
        return list;
    }
}
