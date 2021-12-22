package com.tedu.mybatis;

import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis01_test05 {

    static SqlSession sqlSession = null;

    static {

        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFinaAll() {
        List<Emp> list = sqlSession.selectList("EmpMapper.findAll");
        for (Emp emp : list) {
            System.out.println(emp);
        }

    }

    @Test
    public void testInsert() {
        int i = sqlSession.update("EmpMapper.insert");
        System.out.println(i + "行受到了影响");
    }

    @Test
    public void testUpdate() {
        int i = sqlSession.update("EmpMapper.update");
        System.out.println(i + "行受到了影响");
    }

    @Test
    public void testDelete() {
        int i = sqlSession.update("EmpMapper.delete");
        System.out.println(i + "行受到了影响");
    }


}






