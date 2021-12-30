package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 持久层
 * */
@Mapper
public interface GoodsDao {
    @Select("select id,name,remark,createdTime from tb_goods")
    List<Goods> findAll();


}
