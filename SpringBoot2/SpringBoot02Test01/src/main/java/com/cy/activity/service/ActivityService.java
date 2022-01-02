package com.cy.activity.service;

import cy.activity.pojo.Activity;

import java.util.List;

public interface  ActivityService {
    Activity findById(Long id);
    List<Activity > findAll();
}
