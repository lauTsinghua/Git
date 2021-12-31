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

    @RequestMapping("activity_list")//http://localhost:8080//activity/activity_list
    public String doActivityListUI(Model model) {
        List<Activity> list = activityService.findActivitys();
        model.addAttribute("list", list);

        return "activity_list";
    }

    @RequestMapping("doInsertActivity")//http://localhost:8080//activity/dodoInsertActivity
    public String insertActivity(Activity entity) {
        activityService.insertActivity(entity);
        return "redirect:activity_list";
    }

    @RequestMapping("activity_edit")
    public String doActivityEditUI() {//http://localhost:8080//activity/activity_edit


        return "activity_edit";
    }

}
