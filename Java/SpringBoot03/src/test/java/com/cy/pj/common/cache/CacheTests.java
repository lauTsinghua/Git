package com.cy.pj.common.cache;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTests {


    @Qualifier("defaultCache")
    @Autowired
    private Cache cache;

    private Cache cache1 ;
    private Cache cache2 ;

    @Autowired//通过构造器为属性赋值
    public CacheTests( @Qualifier("defaultCache")Cache cache1, @Qualifier("weakCache")Cache cache2) {
        this.cache1 = cache1;
        this.cache2 = cache2;
    }

    @Test
    public void testCache01(){
        System.out.println(cache);


    } @Test
    public void testCache02(){
        System.out.println(cache1);
        System.out.println(cache2);


    }
}
