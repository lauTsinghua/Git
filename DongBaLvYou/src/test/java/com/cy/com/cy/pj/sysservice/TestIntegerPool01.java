package com.cy.com.cy.pj.sysservice;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestIntegerPool01 {

    @Test
    public void testIntegerCache() {
        //对于Integer,Long类有一个整数池(-128~+127),当超过这个范围时,就需要手动创建对象了.
        Integer t1 = 100;
        Integer t2 = 100;
        Integer t3 = 200;
        Integer t4 = 200;
        System.out.println(t1 == t2); //true
        System.out.println(t3 == t4); //false


    }


}
