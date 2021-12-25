package com.cy.pj.goods.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SqlSessinTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testDeleteById() {
        //1.创建sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //2.执行会话操作
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        int rows = goodsDao.deleteById(8);

        //3.释放资源
        sqlSession.close();
        System.out.println("rows=" + rows);
    }

}
