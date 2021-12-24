package com.tedu.dao;

import com.tedu.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> findAll();

    Integer insert();

    Integer update();

    Integer delete();

}
