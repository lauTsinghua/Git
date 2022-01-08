package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class SysUserController {
    //http://localhost:8080/doIndexUI
    @Autowired
    private SysUserService sysUserService;


    @RequestMapping ("doFindObjectById")
    public JsonResult doFindObjectById(Long id) {
        return new JsonResult(sysUserService .findObjectById(id) );

    }


    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysUser entity, Integer[] roleIds) {
        sysUserService.saveObject(entity, roleIds);
        return new JsonResult("save ok");

    }
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysUser entity, Integer[] roleIds) {
        sysUserService.updateObject(entity, roleIds);
        return new JsonResult("update ok");

    }

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Long pageCurrent) {
        return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
    }

    @RequestMapping("doValidById")
    public JsonResult validById(Long id, Integer valid) {

        int rows = sysUserService.validById(id, valid);
        return new JsonResult("update ok");
    }

    ;

}
