package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysUserDao {
 /**
  *基于用户id查找用户以及用户对应部门信息
  *@param id
  *@return
  **/

   SysUserDeptVo findObjectById(Long  id);

    int insertObject(SysUser entity);
    int updateObject(SysUser entity);

    /**
     * 基于条件查询总记录数
     *
     * @param username
     * @return
     */
    long getRowCount(String username);

    /**
     * 基于条件查询当前页记录
     *
     * @param username
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysUserDeptVo> findPageObjects(String username, long startIndex, int pageSize);

    @Update("update sys_users set valid=#{valid},modifiedUser=#{username},modifiedTime=now() where id=#{id}")
    int validById(Long id, Integer valid, String username);

}
