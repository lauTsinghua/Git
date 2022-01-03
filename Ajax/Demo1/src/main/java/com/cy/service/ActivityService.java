package com.cy.service;

import com.cy.pojo.ActivityPojo;

import java.util.List;

public interface  ActivityService {

    List<ActivityPojo> findAll();
    int   saveActivity(ActivityPojo entity);
    int deleById(Long id);
}
