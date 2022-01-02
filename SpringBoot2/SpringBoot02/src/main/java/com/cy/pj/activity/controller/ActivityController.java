package com.cy.pj.activity.controller;

import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @RequestMapping("doInsertActivity")
    public String insertActivity(Activity entity) {
        if (entity.getId() == null) {
            activityService.insertActivity(entity);
        } else {
            activityService.updateActivity(entity);
        }
        return "redirect:activity_list";
    }

    @RequestMapping("activity_edit")
    public String doActivityEditUI(Model model) {
        model.addAttribute("act", new Activity());
        return "activity_edit";

    }

    @RequestMapping("doFindById")
    public String doFindById(Long id, Model model) {

        Activity activity = activityService.findById(id);
        model.addAttribute("act", activity);
        return "activity_edit";
    }

    @RequestMapping("doUpdateActivity")
    public String doUpdateActivity(Activity entity) {
        activityService.updateActivity(entity);
        return "redirect:activity_list";
    }

    @RequestMapping("doDeleteById")
    public String doDeleteById(Long id) {
        activityService.deleteById(id);
        return "redirect:activity_list";
    }

    @RequestMapping("doFindActivitys")
    @ResponseBody
    public List<Activity> doFindActivitys() {
        List<Activity> list = activityService.findActivitys();
//http://localhost:8080//activity/activity_list
//http://localhost:8080//activity/doFindActivitys
        return list;
    }
}
