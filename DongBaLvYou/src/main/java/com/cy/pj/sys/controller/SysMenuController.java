package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController //==@Controller+@ResponseBody
@RequestMapping("/menu/")
public class SysMenuController {
	//http://localhost:8080/doIndexUI
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysMenu entity) {
		sysMenuService.updateObject(entity);
		return new JsonResult("update ok");
	}
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysMenu entity) {
		sysMenuService.saveObject(entity);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doFindZtreeMenuNodes")
	public JsonResult doFindZtreeMenuNodes() {
		return new JsonResult(sysMenuService.findZtreeMenuNodes());
	}
	
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects() {
		return new JsonResult(sysMenuService.findObjects());
	}
	
}
