package com.cy.controller;

import com.cy.pojo.ActivityPojo;
import com.cy.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/activity/")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("findAll")//http://localhost:8080//activity/findAll

    public String findAll() {
        return "findAll";
    }

    @RequestMapping("doFindActivitys")
    @ResponseBody
    public List<ActivityPojo> doFindActivitys() {//http://localhost:8080//activity/doFindActivitys
        List<ActivityPojo> list = activityService.findAll();
        return list;
    }

}
