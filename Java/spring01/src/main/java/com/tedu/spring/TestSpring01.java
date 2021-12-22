package com.tedu.spring;

import com.tedu.dao.EmpDao;
import com.tedu.service.EmpService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring框架的功能:
 * <p>
 * Bean可以理解为一个可重复的组件
 * 1、凡是子类及带属性、方法的类都注册Bean到Spring中，交给它管理
 * 2、@Bean 用在方法上，告诉Spring容器，你可以从下面这个方法中拿到一个Bean
 */
public class TestSpring01 {
    private static ClassPathXmlApplicationContext ac;//定义一个实例


    static {
        /* ClassPathXmlApplicationContext从类路径加载配置文件并创建对象交给 ac 这个实例 */
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 通过spring容器创建EmpService和EmpDao接口的子类的实例
     */
    @Test
    public void testIOC() {
        //获取spring容器对象,获取EmpService接口的子类实例
        EmpService empService = (EmpService) ac.getBean("empService");
        //getBean("这里面存放来自applicationContext.xml里对应的Id");
        System.out.println(empService);
        //获取spring容器对象,获取EmpDao接口的子类实例
        EmpDao empDao = (EmpDao) ac.getBean("empDao");
        //getBean("这里面存放来自applicationContext.xml里对应的Id");
        System.out.println(empDao);

    }


}
