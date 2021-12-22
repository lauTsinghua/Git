package com.tedu.spring;

import com.tedu.dao.EmpDao;
import com.tedu.pojo.User;
import com.tedu.service.EmpService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring框架的功能:
 *
 * Bean可以理解为一个可重复使用的组件
 * 1、凡是子类及带属性、方法的类都注册Bean到Spring中，交给它管理
 * 2、@Bean 用在方法上，告诉Spring容器，你可以从下面这个方法中拿到一个Bean
 */
public class TestSpring01 {
    private static ClassPathXmlApplicationContext ac;//定义一个变量


    static {
        /* ClassPathXmlApplicationContext 从类路径加载配置文件 */
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 通过spring容器创建EmpService和EmpDao接口的子类的实例
     */
    @Test
    public void testIOC() {
        //获取spring容器对象,获取EmpService接口的子类实例
        EmpService empService = (EmpService) ac.getBean("empService");
        //getBean("这里面存放来自applicationContext.xml里对应的id");
        System.out.println(empService);
        //获取spring容器对象,获取EmpDao接口的子类实例
        EmpDao empDao = (EmpDao) ac.getBean("empDao");
        //getBean("这里面存放来自applicationContext.xml里对应的id");
        System.out.println(empDao);

    }
/**
 * 测试spring bean对象的单实例和多实例
 *
 * 单实例: spring容器从始至终只会为该类创建一个实例,每次获取的实例都是第一次创建的实例
 * 优点:更加节省资源和空间
 * 缺点:因为多个线程获取的是同一个对象，当多个线程访问同一个对象的成员变量时,可能会出现线程安全问题
 * 在没有线程安全问题的情况下推荐使用单实例
 *
 * 多实例: spring容器每次都会为该类创建一个新的实例,每次获取的都是不同的实例
 * 优点:因为每个线程获取的都是不同的对象,访问的也是不同的对象,因此不会有线程安全问题
 * 缺点:会更加消耗资源和内存
 * 在面临多线程,高并发引起的线程安全问题的情况下推荐使用多实例
 * */
@Test
    public void testBean1(){  //单实例 uesr1==user2
    //getBean("这里面存放来自applicationContext.xml里对应的id");
    User user1 = (User) ac.getBean("user1");
    System.out.println(user1);
    User user2 = (User) ac.getBean("user1");
    System.out.println(user2);


}
@Test
    public void testBean2(){  //多实例 uesr1!=user2
    //getBean("这里面存放来自applicationContext.xml里对应的id");
    User user1 = (User) ac.getBean("user2");
    System.out.println(user1);
    User user2 = (User) ac.getBean("user2");
    System.out.println(user2);


}


}
