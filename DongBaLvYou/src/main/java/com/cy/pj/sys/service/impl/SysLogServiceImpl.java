package com.cy.pj.sys.service.impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	
	
	@Override
	public int deleteObjects(int... ids) {
		if(ids==null || ids.length==0) 
			throw new IllegalArgumentException("请先选择");
		int rows=sysLogDao.deleteObjects(ids);
		if(rows==0)
			throw new ServiceException("记录可能已经存在");
		return rows;
	}
	
	@Override
	public PageObject<SysLog> findPageObjects(String username,
			Long pageCurrent){
		//1.参数校验
		if(pageCurrent==null||pageCurrent<1)//pageCurrent=1L;
			throw new IllegalArgumentException("页码值不正确");//message
		//2.查询总记录数并校验
		long rowCount=sysLogDao.getRowCount(username);
		if(rowCount==0)
			//throw new NoSuchElementException("没有查找对应的记录");
			throw new ServiceException("没有查找对应的记录");
		//3.查询当前页记录
		int pageSize=5;
		long startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records=
		sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4.对查询结果进行封装。
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}

}
