package com.tedu.spring;



import com.tedu.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring01 {
    static ClassPathXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }
    @Test
    public void TestUser(){
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        if(user1 ==user2 )
        System.out.println("这是一个scope='singleton'的单例");
        else
            System.out.println("这是一个scope='prototype'的多例");

    }
    @Test
    public void TestUser1(){
       User user = (User) context.getBean("user1");
        System.out.println(user);

    }
    @Test
    public void TestUser2(){
       User user = (User) context.getBean("user2");
        System.out.println(user);

    }


}
