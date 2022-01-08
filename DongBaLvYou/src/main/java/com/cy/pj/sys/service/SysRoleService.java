package com.cy.pj.sys.service;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	
	/**
	 * 基于角色id查询角色以及角色对应的菜单id
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	/**
	 * 更新角色以及角色对应的菜单信息
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int updateObject(SysRole entity,Integer[] menuIds);
	 /**
	  * 保存角色以及角色对应的菜单信息
	  * @param entity
	  * @param menuIds
	  * @return
	  */
	 int saveObject(SysRole entity,Integer[] menuIds);
	
	 int deleteObject(Integer id);

	 PageObject<SysRole> findPageObjects(String name,Long pageCurrent);
}
