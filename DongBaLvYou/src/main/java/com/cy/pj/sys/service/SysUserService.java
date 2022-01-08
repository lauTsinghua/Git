package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.vo.SysUserDeptVo;

public interface SysUserService {

	/**
	 * 查询当前页要呈现的用户信息以及分页信息
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	 PageObject<SysUserDeptVo> findPageObjects(String username,
			 Long pageCurrent);
}
