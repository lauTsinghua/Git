package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;
import com.cy.pj.sys.vo.SysUserMenuVo;

public interface SysUserService {
    /**
     * 基于用户ID查询用户对应的一级二级菜单信息
     * **/

    List<SysUserMenuVo> findUserMenusByUserId(Long  id);


    int updatePassword(String password, String newPassword, String cfgpassword);


    /**
     * 查询并封装用户信息以及用户对应的角色信息
     *
     * @param id
     * @return
     */
    Map<String, Object> findObjectById(Long id);

    /**
     * 更新用户以及用户对应的角色信息
     *
     * @param entity
     * @param roleIds
     * @return
     */
    int updateObject(SysUser entity, Integer[] roleIds);

    /**
     * 保存用户以及用户对应的角色信息
     *
     * @param entity
     * @param roleIds
     * @return
     */
    int saveObject(SysUser entity, Integer[] roleIds);

    int validById(Long id, Integer valid);

    /**
     * 查询当前页要呈现的用户信息以及分页信息
     *
     * @param username
     * @param pageCurrent
     * @return
     */
    PageObject<SysUserDeptVo> findPageObjects(String username,
                                              Long pageCurrent);
}
