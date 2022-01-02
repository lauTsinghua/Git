package com.cy.activity;

import com.cy.activity.service.ActivityService;

import cy.activity.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/activity/")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping ("findById")
    public String findById(Long id, Model model) {//http://localhost:8080/activity/findById&id=1
        Activity activity = activityService.findById(id);
      model .addAttribute("activity",activity);
      return "redirect:findAll";
    }
    @RequestMapping ("findAll")
    public String   findAll(Model model) {//http://localhost:8080/activity/findAll
        List<Activity> activity = activityService.findAll();
        model .addAttribute("activity",activity);
      return "activity";
    }


}
