package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface  GoodsDao {
    @Select("select id,name,remark,createdTime from tb_goods")
    List<Goods> findObejects() ;

}
