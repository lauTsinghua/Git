package com.tedu.mybatis;


import com.tedu.dao.EmpMapper;
import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis02_test01 {
    static EmpMapper empMapper;

    static {
        try {

            empMapper = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MybatisConfig.xml")).openSession(true).getMapper(EmpMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void TestFindAll() {
        Double salary = 0000d;
        List<Emp> list = empMapper.findAll(salary);
        for (Emp emp : list) {
            System.out.println(emp);
        }

    }

    @Test
    public void TestInsert1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","徐长卿") ;
        map.put("job","蜀山道士") ;
        map.put("salary",5000) ;

        Integer insert = empMapper.insert1(map);
        System.out.println(insert + "行受到了影响");
    }

    @Test
    public void TestInsert2() {
        Emp emp=new Emp() ;
        emp .setName("景天");
        emp.setJob("跑堂");
        emp.setSalary(4000d);
        Integer insert = empMapper.insert2(emp);
        System.out.println(insert + "行受到了影响");
    }

    @Test
    public void TestUpdate() {
        Map<String,Object > map =new HashMap();
        map.put("id", "50");
        map.put("name", "龙葵");
        Integer insert = empMapper.update(map);
        System.out.println(insert + "行受到了影响");
    }

    @Test
    public void TestDelete() {
        String name="龙葵";
        Integer insert = empMapper.delete(name);
        System.out.println(insert + "行受到了影响");
    }


}






