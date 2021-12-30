package com.cy.pj.goods.dao;


import com.cy.pj.goods.pojo.GoodsPojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
/**数据层**/
import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("select id,name,remark,createdTime from tb_goods")
    List<GoodsPojo> findObejects();

    @Delete("delete from tb_goods where id=#{id}")
    int  deleteById(Long id);
}
