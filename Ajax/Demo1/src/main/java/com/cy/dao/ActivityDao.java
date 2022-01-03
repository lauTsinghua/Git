package com.cy.dao;

import com.cy.pojo.ActivityPojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface  ActivityDao {

@Select("select id,title,category,startTime,endTime,state,remark,createdUser,createdTime from tb_activity")
    List <ActivityPojo> findAll();

    @Insert("insert into tb_activity (title,category,startTime,endTime,state,remark,createdUser,createdTime) " +
            "values(#{title},#{category},#{startTime},#{endTime},#{state},#{remark},#{createdUser},#{createdTime})")
    int SaveActivity(ActivityPojo  entity);
    @Delete("delete from  tb_activity  where id=#{id};")
    int deleById(Long id);

}
