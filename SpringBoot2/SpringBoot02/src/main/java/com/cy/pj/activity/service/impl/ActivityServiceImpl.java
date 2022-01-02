package com.cy.pj.activity.service.impl;

import com.cy.pj.activity.dao.ActivityDao;
import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ActivityServiceImpl implements ActivityService {
    private static final Logger log = //获取该类日志的实现
            LoggerFactory.getLogger(ActivityServiceImpl.class);
    @Autowired
    private ActivityDao activityDao;


    @Override
    public List<Activity> findActivitys() {  //查询所有数据
        log.info("start:{}", System.currentTimeMillis());
        List<Activity> list = activityDao.findActivitys();
        log.info("end:{}", System.currentTimeMillis());
        return list;
    }

    @Override
    public Activity findById(Long id) { //根据指定id进行查询
        if (id == null || id < 1) {
            throw new IllegalArgumentException("您输入的ID不正确");
        } else {
            log.info("start:{}", System.currentTimeMillis());
            Activity activity = activityDao.findById(id);
            log.info("end:{}", System.currentTimeMillis());
            if (activity == null) {
                throw new NoSuchElementException("您要查找的数据可能已经不存在");
            }
            return activity;
        }
    }

    @Override
    public int insertActivity(Activity entity) {  //插入一条新数据
        log.info("start:{}", System.currentTimeMillis());
        entity.setCreatedTime(LocalDateTime.now());
        int rows = activityDao.insertActivity(entity);
        log.info("end:{}", System.currentTimeMillis());
        return rows;
    }

    @Override
    public int updateActivity(Activity entity) {  //对指定数据进行修改
        int rows = activityDao.updateActivity(entity);
        return rows;
    }

    @Override
    public int deleteById(Long id) { //对指定数据进行删除
        int rows = activityDao.deleteById(id);
        return rows;
    }


}
