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

        int row = goodsDao.deleteObjects();
        System.out.println("row=" + row);
        int rows = goodsDao.deleteObjects(4, 5, 6, 7, 8);
        System.out.println("rows=" + rows);

    }

    @Test
    public void testFindAll() {
        for (Emp emp : goodsDao.findAll()) {
            System.out.println(emp);
        }
    }

    @Test
    public void testInert() {
        String name = "程晓宇";
        String job = "程序员";
        Double salary = 3700d;
        Emp emp = new Emp();
        emp.setName(name);
        emp.setJob(job);
        emp.setSalary(salary);
        int row2 = goodsDao.insertObject(emp);
        System.out.println("row2=" + row2);

    }
}
