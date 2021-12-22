package com.tedu.mybatis;

import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis01_test04 {

static  SqlSession sqlSession = null;
    static {

        try {

            InputStream inputStream = Resources.getResourceAsStream("MybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//基build()里的配置信息于创建一个对象
            sqlSession = sqlSessionFactory.openSession(true);//用这个对象去自动处理这个事务
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void TestFindAll() {
        List<Emp> list = sqlSession.selectList("EmpMapper.findAll");//执行EmpMapper.findAll的SQL语句
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void TestInsert() {
        int rows = sqlSession.update("EmpMapper.insert");
        System.out.println(rows+"行受到了影响");

    }
      @Test
    public void TestUpdate() {
        int rows = sqlSession.update("EmpMapper.update");
        System.out.println(rows+"行受到了影响");

    }
      @Test
    public void TestDelete() {
        int rows = sqlSession.update("EmpMapper.delete");
        System.out.println(rows+"行受到了影响");

    }



}






