package com.cy.pj.activity.dao;

import com.cy.pj.activity.pojo.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ActivityDao {
    @Insert("insert into tb_activity (title,category,startTime,endTime,state,remark,createdUser,createdTime) " +
            "values(#{title},#{category},#{startTime},#{endTime},#{state},#{remark},#{createdUser},#{createdTime})")
    int insertActivity(Activity entity);

    @Select("select id,title,category,startTime,endTime,state,remark,createdUser,createdTime from tb_activity  where id=#{id}")
    Activity findById(Long id);

    @Select("select id,title,category,startTime,endTime,state,remark,createdUser,createdTime from tb_activity")
    List<Activity> findActivitys();

    @Update("update tb_activity set title=#{title},category=#{category},startTime=#{startTime},endTime=#{endTime},state=#{state},remark=#{remark} where id=#{id}")
    int updateActivity(Activity entity);

    @Update("delete from  tb_activity  where id=#{id};")
    int deleteById(Long id);
}
