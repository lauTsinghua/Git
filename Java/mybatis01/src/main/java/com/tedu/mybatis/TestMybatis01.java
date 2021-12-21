package com.tedu.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.pojo.Emp;

/**
 * mybatis快速入门程序
 */
public class TestMybatis01 {

    /**
     * 练习1: 查询emp表中的所有员工信息
     * 一共5个步骤
     * 1.读取mybatis的核心配置文件(mybatis-config.xml)
     * 2.基于配置信息获取一个SqlSessionFactory工厂对象
     * 3.通过工厂对象获取一个SqlSession对象
     * 4.执行SQL语句(EmpMapper.xml), 接收处理后的结果
     * 5.输出结果
     *
     */
    @Test
    public void findAll() throws Exception {
        //1.读取mybatis的核心配置文件(mybatis-config.xml)
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.基于配置信息获取一个SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.通过工厂对象获取一个SqlSession对象
        //默认是false,表示需手动提交事务, true表示自动提交事务
        SqlSession session = factory.openSession(true);
        //4.执行SQL语句(EmpMapper.xml), 接收处理后的结果
        List<Emp> list = session.selectList("EmpMapper.findAll");
        /*List<Emp> list = session.selectList("namespace.id");
         对应EmpMapper.xml文件中的namespace和id属性须唯一
          namespace="EmpMapper" id="findAll"*/
        //5.输出结果
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}






