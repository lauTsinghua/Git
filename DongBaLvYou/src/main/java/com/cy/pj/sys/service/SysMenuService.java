package com.cy.pj.sys.service;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {

    List<Map<String, Object>> findObjects();

    /**
     * 查询上级菜单信息
     */
    List<Node> findZtreeMenuNodes();

    /**
     * 基于菜单id删除菜单以及菜单对应的关系数据
     */
    int deleteobject(Integer id);

    /**
     * 添加菜单信息
     */
    int saveObject(SysMenu entity);

    /**
     * 基于菜单id修改菜单以及菜单对应的关系数据
     */
    int updateObject(SysMenu entity);
}
