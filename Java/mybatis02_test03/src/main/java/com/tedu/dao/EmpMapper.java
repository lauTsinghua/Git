package com.tedu.dao;

import com.tedu.pojo.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    List<Emp> findAll(Double salary);



    Integer update(Map<String, Object> map);

    Integer delete(String name);

    Integer insert1(Map<String, Object> map);

    Integer insert2(Emp emp);
}
