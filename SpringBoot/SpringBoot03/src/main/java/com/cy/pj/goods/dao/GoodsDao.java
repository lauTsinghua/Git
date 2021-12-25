package com.cy.pj.goods.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * 基于多个ID进行数据库的删除操作
 * 方法参数是可变参数(数组)时，我们在sql映射中可以使用array变量接收参数数据，
 * <foreach collection="array"
 * 假如不希望使用array，可以借助@Param注解在接口方法中对参数进行描述
 * <foreach collection="ids"
 *
 * @param ids
 */

@Mapper
public interface GoodsDao {
    int deleteObjects(@Param("ids") Integer... ids);

    List<Emp> findAll();

    @Update("INSERT INTO emp VALUES (NULL, #{name}, #{job}, #{salary});")
    int insertObject(Emp emp);

    @Update("update emp set name=#{name} job= #{job} salary=#{salary} where name = 程晓宇;")
    int updateObject(Emp emp);
}
