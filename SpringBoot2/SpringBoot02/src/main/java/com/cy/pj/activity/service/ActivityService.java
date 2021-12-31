package com.cy.pj.activity.service;

import com.cy.pj.activity.pojo.Activity;

import java.util.List;

public interface ActivityService {
    int insertActivity(Activity entity);
    List <Activity>findActivitys();
}
