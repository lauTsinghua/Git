package com.cy.pj.sys.pojo.sys;


import com.cy.pj.sys.entity.SysLog;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Date;

@SpringBootTest
public class TextSerializable01 {

    @Test
    public void textSerializable() throws Exception {
        SysLog log = new SysLog();
        log.setId(100);
        log.setIp("192.168.1.111");
        log.setUsername("admin");
        log.setOperation("Update");
        log.setMethod("xxx.deleteObject");
        log.setTime(10l);
        log.setCreatedTime(new Date());
        //将log对象序列化
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("f1.txt")));
        out.writeObject(log);
        out.close();

        System.out.println("序列化 ok");
    }

    @Test
    public void textDeSerializable() throws Exception {
        //将log对象反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("f1.txt")));
        Object object = in.readObject();
        in.close();
        System.out.println(object);

    }

}
