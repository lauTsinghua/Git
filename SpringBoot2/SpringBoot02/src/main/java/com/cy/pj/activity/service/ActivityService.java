package com.cy.pj.activity.service;

import com.cy.pj.activity.pojo.Activity;

import java.util.List;

public interface ActivityService {
    List <Activity>findActivitys();
    int insertActivity(Activity entity);
    Activity findById(Long id);
    int updateActivity(Activity entity);
    int deleteById(Long id);
}
