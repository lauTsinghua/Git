package com.tedu.mybatis;


import com.tedu.dao.EmpMapper;
import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 占位符的测试
 */

public class TestMybatis02_test02 {
    static EmpMapper empMapper = null;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("MybatisConfig.xml");
            empMapper = new SqlSessionFactoryBuilder().build(inputStream).openSession(true).getMapper(EmpMapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindAll() {
        Double salary =0d;
        for (Emp emp : empMapper.findAll(salary)) {
            System.out.println(emp);
        }
    }

    @Test
    public void TestInsert1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","唐雪见");
        map.put("job","唱歌");
        map.put("salary",4500d);
        Integer integer = empMapper.insert1(map);
        System.out.println(integer+"行受到了影响!");
    }
    @Test
    public void TestInsert2() {
       Emp emp =new Emp() ;
        emp .setName("龙葵");
        emp.setJob("跳舞");
        emp.setSalary(3000d);
        Integer integer = empMapper.insert2(emp);
        System.out.println(integer+"行受到了影响!");
    }
    @Test
    public void TestUpdate1(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","紫萱");
        map.put("salary",4500d);
        Integer integer = empMapper.update1(map);
        System.out.println(integer+"行受到了影响!");
    }
    @Test
    public void TestUpdate2(){
        Emp emp =new Emp() ;
        emp .setName("龙葵");
        emp.setSalary(3000d);
        Integer integer = empMapper.update2(emp );
        System.out.println(integer+"行受到了影响!");
    }
@Test
    public void TestDelete(){
        Integer id=48;
    Integer integer = empMapper.delete(id);
    System.out.println(integer+"行受到了影响!");

}

}






