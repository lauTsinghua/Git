package com.cy.pj.goods.dao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestGoodsDao {

    @Autowired
    private GoodsDao goodsDao;


    @Test
    public void testDeleteObjects() {


        int rows = goodsDao.deleteObjects(46, 51);
        System.out.println("rows=" + rows);

    }


}
