package com.tedu.mybatis;


import com.tedu.dao.EmpMapper;
import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class TestMybatis02_test01 {
    static EmpMapper empMapper = null;

    static {

        try {
            InputStream inputStream = Resources.getResourceAsStream("MybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            empMapper = sqlSession.getMapper(EmpMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindAll() {
        for (Emp emp : empMapper.findAll()) {
            System.out.println(emp);
        }
    }

    @Test
    public void TestInsert() {
        Integer integer = empMapper.insert();
        System.out.println(integer + "行受到了影响影响");
    }

    @Test
    public void TestUpdate() {
        Integer integer = empMapper.update();
        System.out.println(integer + "行受到了影响影响");
    }

    @Test
    public void TestDelete() {
        Integer integer = empMapper.delete();
        System.out.println(integer + "行受到了影响影响");
    }


}






