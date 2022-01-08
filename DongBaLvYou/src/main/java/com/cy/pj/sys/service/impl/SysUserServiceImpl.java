package com.cy.pj.sys.service.impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.service.SysUserService;
import com.cy.pj.sys.vo.SysUserDeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
    private SysUserDao sysUserDao;
	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent) {
		//1.参数校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数并校验
		long rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		//3.查询当前页记录
		int pageSize=3;
		long startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDeptVo> records=
		sysUserDao.findPageObjects(username, startIndex, pageSize);
		//4.封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}

}
