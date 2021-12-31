package com.cy.pj.activity.controller;

import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/activity/")
public class ActivityController {


    @Autowired
    private ActivityService activityService;
@RequestMapping ("doActivityUI")//http://localhost:8080//activity/doActivityUI
    public String doFindActivitys(Model model) {
        List<Activity> list = activityService.findActivitys();
        model.addAttribute("list", list);

        return "activity";
    }


}
