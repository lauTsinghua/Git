package com.cy.activity.dao;

import cy.activity.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface  ActivityDao {

    @Select("select id,title,category,startTime,endTime,state,remark,createdUser,createdTime from tb_activity  where id=#{id}")
    Activity findById(Long id);
    @Select("select id,title,category,startTime,endTime,state,remark,createdUser,createdTime from tb_activity")
    List<Activity > findAll();

}
