package com.cy.controller;

import com.cy.pojo.ActivityPojo;
import com.cy.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/activity/")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    //http://localhost:8080//activity/findAll
    @RequestMapping("findAll")
    public String findAll() {
        return "findAll";
    }

    @RequestMapping("doFindActivitys")
    @ResponseBody
    public List<ActivityPojo> doFindActivitys() {
        List<ActivityPojo> list = activityService.findAll();
        return list;
    }

    @RequestMapping("edit")
    public String doActivityEditUI() {

        return "edit";
    }

    @RequestMapping("doSaveActivity")
    @ResponseBody
    public String doSaveActivity(ActivityPojo entity) {
        activityService.saveActivity(entity);
        return "save ok";
    }

    @RequestMapping("doDeleteById")//http://localhost:8080//activity/doDeleteById&id=2
    public String doDeleteById(Long id) {
        activityService.deleById(id);
        return  "redirect:findAll";
    }
}
