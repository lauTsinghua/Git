package com.tedu.dao;

import com.tedu.pojo.Emp;

import java.util.List;

/**
 * Mapper 接口
 *全限定类名: com.tedu.dao.EmpMapper
 *
 * 1.创建一个mapper接口，要求接口的全限定类名和mapper文件的namespace值相同
 * **/
public interface EmpMapper {
    /*mapper文件中的每一个SQL语句,在mapper接口要添加一个对应的方法,
    并且接口中的方法名和SQL标签上的Id值要相同*/
    /**查询emp中所有的员工信息**/
    public List<Emp> findAll();
}
