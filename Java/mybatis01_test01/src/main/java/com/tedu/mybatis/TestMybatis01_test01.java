package com.tedu.mybatis;


import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis快速入门程序
 */
public class TestMybatis01_test01 {

    /**
     * 练习1: 查询emp表中的所有员工信息
     * 一共5个步骤
     *  Resources.getResourceAsStream 1.读取mybatis的核心配置文件(MybatisConfig.xml)
     * 2.基于配置信息获取一个SqlSessionFactory工厂对象
     * 3.通过工厂对象获取一个SqlSession对象
     *  //默认是false,表示需手动提交事务, true表示自动提交事务
     * 4.执行SQL语句(EmpMapper.xml), 接收处理后的结果
     * 5.输出结果
     *
     */
    @Test
    public void findAll() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<Emp> list = sqlSession.selectList("EmpMapper.findAll");
        for (Emp emp:list) {
            System.out.println(emp);
        }

    }
}






