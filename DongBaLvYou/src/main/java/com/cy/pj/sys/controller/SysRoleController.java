package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role/")
public class SysRoleController {
	//http://localhost:8080/doIndexUI
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysRoleService.findObjectById(id));
	}
	
	@RequestMapping("doUpdateObject")//"name=aa&note=aaaa&menuIds=1,2,3,4"
	public JsonResult doUpdateObject(SysRole entity,Integer[]menuIds) {
		sysRoleService.updateObject(entity, menuIds);
		return new JsonResult("update ok");
	}
	@RequestMapping("doSaveObject")//"name=aa&note=aaaa&menuIds=1,2,3,4"
	public JsonResult doSaveObject(SysRole entity,Integer[]menuIds) {
		sysRoleService.saveObject(entity, menuIds);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysRoleService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String name,Long pageCurrent) {
		return new JsonResult(sysRoleService.findPageObjects(name, pageCurrent));
	}
	@RequestMapping("doFindRoles")
	public JsonResult  findRoles(){

		List<CheckBox> list = sysRoleService.findObjects();

		return new JsonResult(list) ;

	}

}
