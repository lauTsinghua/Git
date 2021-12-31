package com.cy.pj.activity.dao;

import com.cy.pj.activity.pojo.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActivityDaoTests {

    @Autowired
    private ActivityDao activityDao ;

    @Test
    public void TestFindActivitys(){
        List<Activity> list = activityDao.findActivitys();
        for (Activity activity :list) {
            System.out.println(activity);
        }

    }



}
