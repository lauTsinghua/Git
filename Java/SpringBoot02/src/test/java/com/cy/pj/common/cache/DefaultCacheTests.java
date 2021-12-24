package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;//spring 的测试包
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootTest
public class DefaultCacheTests {

    /**
     *@Component 表示用Spring容器通过反射去创建一个对象 。
     *
     * @Scope 必须跟在@Component 后面，表示创建对象时是单例还是多例，默认使用单例，可以省略不写。
     * @Scope("singleton") 单例
     * @Scope("prototype")多例
     *
     * @Lazy 表示延迟加载或者叫懒加载，当需要创建对象时，才会通过Spring容器创建一个对象。（只有在单例时懒加载才会生效，默认是true，可以省略不写。）
     * @Lazy（true）使用延时加载（必须是单例模式）
     * @Lazy（false）不使用延时加载
     *
     * @SpringBootTest 表示这个类为一个Spring容器的单元测试的类。
     *
     * @Autowired 让Spring容器去注入属性的值，一个属性对应一个@Autowired。

     * @PostConstruct Servle的t生命周期方法。在对象加载完依赖注入后执行，用来初始化一下资源。
     * 顺序：Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
     *
     * @PreDestroy Servlet的生命周期方法。在对象销毁之前执行，用来释放对象一直持有的资源。
     * 支持@PostConstruct 注解的类都必须支持该注解。
     */

    @Autowired
    private DefaultCache defaultCache;
    @Autowired
    private DefaultCache cache;

    @Test
    public void testDefaultCache01() {
        if (defaultCache == cache)
            System.out.println("@Scope(\"singleton\") 单例模式");
        else
            System.out.println("@Scope(\"prototype\") 多例模式");

    }
    @PostConstruct//@PostConstruct Servle的t生命周期方法。在对象加载完依赖注入后执行，用来初始化一下资源。
    public void init(){
        System.out.println("init()");
    }
    @PreDestroy//@PreDestroy Servlet的生命周期方法。在对象销毁之前执行，用来释放对象一直持有的资源。
    public void destroy(){
        System.out.println("destroy()");
    }
}
