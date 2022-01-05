package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuDao {
    /**
     * 获取所有的菜单信息,包括当前菜单对应的选择菜单
     */
    List<Map<String, Object>> findObjects();

    /**
     * 查询菜单的id,name , parentName
     */
    @Select("select id,name,parentId from sys_menus")
    List<Node> findZtreeMenuNodes();

    /**
     * 根据id进行字段删除
     */
    @Delete("delete from sys_menus where id=#{id}")
    int deleteobject(Integer id);

    /**
     * 添加菜单对象里的字段
     */
    int insertObject(SysMenu entity);

    /**
     * 修改菜单对象的字段
     */
    int updateObject(SysMenu entity);
}
