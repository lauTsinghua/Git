package com.cy.pj.goods.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * DAO:数据访问对象
 * GoodsDao:商品表对应的数据访问对象
 *
 * @Mapper 注解用于描述数据层接口, 由Mybatis框架定义, 通过此注解描述的接口,
 * 系统底层会为其创建实现类,并且会创建其实现类对象然后交给Spring框架进行管理
 */
@Mapper
public interface GoodsDao {
    /**
     * 基于id执行商品数据的删除操作
     *
     * @param id 商品id
     * @return 删除的行数
     */
    @Delete("delete from tb_goods where id=#{id}")
    int deleteById(Integer id);
}
