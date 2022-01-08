package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

import java.util.Map;


public interface SysUserService {

	/**
	 * 封装查询到的用户信息以及用户所对应的部门信息
	 * **/
Map<String,Object >findObjectById(Long id);

	/**
	 * 查询当前页要呈现的用户信息以及分页信息
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	 PageObject<SysUserDeptVo> findPageObjects(String username,
			 Long pageCurrent);

	int validById(Long id,Integer valid);

	/**
	 保存用户以及用户对应的角色信息
	 *@param entity
	 *@param roleIds
	 * *@return
	 */

	int saveObject(SysUser entity,Integer[] roleIds);

	/**更新用户和对应角色信息*/
	int updateObject(SysUser entity,Integer[] roleIds);



}
