package com.cy.framwork.spring;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.annotation.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * 项目启动时,类的加载过程
 * **/
@Retention(RetentionPolicy.RUNTIME)//运行时生效
@Target(ElementType.TYPE) //设置Componet注解可以描述的对象
@interface Component { }

class Container { }
@Component
public class TestScanClass01 {
    static Map<String, Object> beanPoool = new HashMap<>();

    public static void main(String[] args) throws Exception {
        //1.获取启动类的字节码对象
        Class<?> cls = TestScanClass01.class;
        //2.获取启动类所在的包名
        String pkgName = cls.getPackage().getName();
        System.out.println("pkgName=" + pkgName);
        //3.将包结构转化为目录结构
        String clsDir = pkgName.replace(".", "/");
        System.out.println(clsDir);
        //4.获取类对应的目录
        URL url = ClassLoader.getSystemResource(clsDir);// ClassLoader 类加载器
        System.out.println("path:" + url.getPath());
        //5.使用File对象获取目录下所有的类
        File file = new File(url.getPath());
        String[] classNames = file.list(new FilenameFilter() {

            public boolean accept(File dir, String name) {

                return name.endsWith(".class");
            }
        });

//6.加载类,并基于类的配置信息
        String classShortName = null;
        for (String className : classNames) {
            classShortName = className.substring(0, className.lastIndexOf("."));


        Class<?> clsObject =
                ClassLoader.getSystemClassLoader().loadClass(pkgName + "." + classShortName);
        System.out.println(clsObject.getName());
        //boolean flag = clsObject.isAnnotationPresent(Component.class);//isAnnotationPresent 检查是否带 @Component  注解
        Annotation an = clsObject.getAnnotation(Component.class);//JAVA的接口都会默认实现Annotation接口  与上条代码等价
            /**
             * 检查是否带 @Component 注解
             * 只有类上面带有 @Component 注解的类才能被创建对象
             * **/
        if (an == null)
            continue;
        Object instance = clsObject.newInstance();//底层通过构造方法去创建对象(反射)
        beanPoool.put(classShortName.substring(0,1).toLowerCase()+classShortName.substring(1),instance);//用于将类的首字母转为小写

    }
        //7.输出beanPool中的对象
        System.out.println(beanPoool );
    }

}
