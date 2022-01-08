package com.cy.pj.sys.dao;

import com.cy.pj.sys.vo.SysUserDeptVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao {
       /**
        * 基于条件查询总记录数
        * @param username
        * @return
        */
	   long getRowCount(String username);
	   /**
	    * 基于条件查询当前页记录
	    * @param username
	    * @param startIndex
	    * @param pageSize
	    * @return
	    */
	   List<SysUserDeptVo> findPageObjects(String username,long startIndex,int pageSize);
}
