package com.cy.dao;

import com.cy.pojo.ActivityPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface  ActivityDao {

@Select("select id,title,category,startTime,endTime,state,remark,createdUser,createdTime from tb_activity")
    List <ActivityPojo> findAll();
}
