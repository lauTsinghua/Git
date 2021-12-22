package com.tedu.mybatis;

import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;

/**
 * mybatis的增删改查和占位符#{}${}
 */
public class TestMybatis02 {
    private static SqlSession session = null;

    static {
        // 对SqlSession 进行初始化
        try {

            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
         session = factory.openSession(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    /**新增员工信息:刘德华 歌手 8888*/
    @Test
    public void testInsert(){
        int rows = session.update("EmpMapper.insert");
        System.out.println(rows+"行增加成功!");


    }
    /**修改员工信息:刘德华 为演员 薪资为 88888*/
    @Test
    public void testUpdate(){
        int rows = session.update("EmpMapper.update");
        System.out.println(rows+"行修改成功!");

    }
    /**删除员工信息:刘德华 */
    @Test
    public void testDelete(){
        int rows = session.update("EmpMapper.delete");
        System.out.println(rows+"行删除成功!");

    }

    /*===================占位符练习=======================**/
    /**新增员工信息:刘德华 歌手 8888*/
    @Test
    public void testFindById(){
        Integer id=1;
        Emp emp = session.selectOne("EmpMapper.findById",id);//selectOne("定位标识",参数);
        System.out.println(emp);


    }
}








