package com.tedu.dao;

import com.tedu.pojo.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    List<Emp> findAll(Double salary);



    Integer insert2(Emp emp);
    

    Integer delete(Integer id);

    Integer update1(Map<String, Object> map);

    Integer update2(Emp emp);

    Integer insert1(Map<String, Object> map);
}
