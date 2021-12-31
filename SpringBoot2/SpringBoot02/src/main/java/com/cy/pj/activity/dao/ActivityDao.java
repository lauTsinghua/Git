package com.cy.pj.activity.dao;

import com.cy.pj.activity.pojo.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ActivityDao {
@Insert("insert into tb_activity (title,category,startTime,endTime,state,remark,createdUser,createdTime) " +
        "values(#{title},#{category},#{startTime},#{endTime},#{state},#{remark},#{createdUser},#{createdTime})")
int insertActivity(Activity entity);


    @Select("select id,title,category,startTime,endTime,state,remark,createdUser,createdTime from tb_activity")
    List<Activity> findActivitys();


}
