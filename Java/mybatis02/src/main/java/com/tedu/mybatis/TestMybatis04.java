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
import java.util.List;

/**
 * Mapper接口开发
 * <p>
 * 1.创建一个mapper接口，要求接口的全限定类名和mapper文件的namespace值相同
 * 2.mapper文件中的每一个SQL语句,在mapper接口要添加一个对应的方法,并且接口中的方法名和SQL标签上的Id值要相同
 * 3.mapper接口中方法上的参数类型和SQL标签上的resultType即返回类型也要相同
 * 4.接口中,方法的返回值类型和SQL标签上的resultType即返回值类型也要相同(
 * 如果方法返回的是一个集合,例如List<Emp>,在resultType中只需要指定集合中的泛型,即Emp类型)
 */

public class TestMybatis04 {
    static SqlSession sqlSession = null;

    static {

        try {

            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//基build()里的配置信息于创建一个对象
            sqlSession = sqlSessionFactory.openSession(true);//用这个对象去自动处理这个事务
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
/**Mapper接口测试***/
    /**
     * 查询所有员工信息
     ***/
    @Test
    public void testFindAll() {
        /*第一步:获取EmpMapper接口的子类对象/实例*/

        //将EmpMapper接口的字节码对象传给getMapper方法,框架底层会根据EmpMapper接口的
        //字节码对象,为接口提供一个实现类/子类,再根据实现类/子类创建一个实例并返回
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        /* 第二步:调用findAll方法查询所有员工信息*/

        //findAll方法底层如何实现:
        // findAll方法底层会根据接口的 [全限定类名+当前方法的名字] 去执行要执行的语句
        List<Emp> list = empMapper.findAll();
        for (Emp emp : list) {
            System.out.println(emp);
        }


    }


}






