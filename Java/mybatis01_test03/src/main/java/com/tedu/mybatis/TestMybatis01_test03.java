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

public class TestMybatis01_test03 {
@Test
    public void findAll() throws IOException {
    InputStream in = Resources.getResourceAsStream("MybatisConfig.xml");//加载配置
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);//基build(in)的配置信息于创建一个对象
    SqlSession sqlSession = sqlSessionFactory.openSession(true);//用这个对象去自动处理这个事务
    List<Emp> list = sqlSession.selectList("EmpMapper.findAll");//执行EmpMapper.findAll的SQL语句
    for (Emp emp : list) {
        System.out.println(emp);
    }


}


}






