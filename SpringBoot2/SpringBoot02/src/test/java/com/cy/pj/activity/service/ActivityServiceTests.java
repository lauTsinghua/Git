package com.cy.pj.activity.service;

import com.cy.pj.activity.pojo.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActivityServiceTests {
    @Autowired
    private ActivityService activityService ;
    @Test
    public void TestFindActivitys(){
        List<Activity> list = activityService .findActivitys();
        for (Activity activity :list) {
            System.out.println(activity);
        }

    }



}
