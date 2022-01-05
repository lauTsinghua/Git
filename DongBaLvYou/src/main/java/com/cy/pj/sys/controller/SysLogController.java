package com.cy.pj.sys.controller;


import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.ServiceNotFoundException;


@RequestMapping("/log/")
@Controller
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String username, Long pageCurrent) {
        //http://localhost:8080/log/doFindPageObjects?pageCurrent=1
        PageObject<SysLog> pageObject = sysLogService.findPagesObject(username, pageCurrent);

        return new JsonResult(pageObject);
    }

    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeletObjects(int... ids) {
        //http://localhost:8080/log/doDeleteObjects?ids=1
        try {
            sysLogService.deleteObjects(ids);
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
        }
        return new JsonResult("删除成功");


    }

}
