package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysRoleDao {
	
	  SysRoleMenuVo findObjectById(Integer id);

	  /**
	   * 更新角色自身信息
	   * @param entity
	   * @return
	   */
	  @Update("update sys_roles set name=#{name},note=#{note},modifiedTime=now(),modifiedUser=#{modifiedUser} where id=#{id}")
	  int updateObject(SysRole entity);
	  
	  /**
	   * 保存角色自身信息
	   * @param entity
	   * @return
	   */
	  int insertObject(SysRole entity);
	  /**
	   * 基于角色id删除角色自身信息
	   * @param id
	   * @return
	   */
	   @Delete("delete from sys_roles where id=#{id}")
	   int deleteObject(Integer id);
       /**
        * 查询总记录数
        * @param name
        * @return
        */
	   long getRowCount(String name);
	   /**
	    * 查询当前页记录
	    * @param name
	    * @param startIndex
	    * @param pageSize
	    * @return
	    */
	   List<SysRole> findPageObjects(String name,long startIndex,int pageSize);
}



