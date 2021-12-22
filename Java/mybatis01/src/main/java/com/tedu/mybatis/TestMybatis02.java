package com.tedu.mybatis;

import com.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis的增删改查和占位符#{}${}
 */
public class TestMybatis02 {
    private static SqlSession session = null;

    static {
        // 对SqlSession 进行初始化
        try {

            InputStream in = Resources.getResourceAsStream("MybatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
         session = factory.openSession(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    @Test
    public void testFindAll() {
        List<Emp> list = session.selectList("EmpMapper.findAll");
        for (Emp emp:list) {
            System.out.println(emp);
        }

    }
    /**新增员工信息:刘德华 歌手 8888*/
    @Test
    public void testInsert(){
        int rows = session.update("EmpMapper.insert");
        System.out.println(rows+"行增加成功!");


    }
    /**修改员工信息:刘德华 为演员 薪资为 88888*/
    @Test
    public void testUpdate(){
        int rows = session.update("EmpMapper.update");
        System.out.println(rows+"行修改成功!");

    }
    /**删除员工信息:刘德华 */
    @Test
    public void testDelete(){
        int rows = session.update("EmpMapper.delete");
        System.out.println(rows+"行删除成功!");

    }

    /**=============================================占位符练习================================================**/
    /**查找对应ID的员工信息*/
    @Test
    public void testFindById(){
        Integer id=1;
        Emp emp = session.selectOne("EmpMapper.findById",id);//selectOne("定位标识",参数);
        System.out.println(emp);


    }
    /**新增员工信息:用Map进行封装*/
    @Test
    public void testInsert2(){
       //将参数封装到一个map中
        Map<String,Object> map=new HashMap<>();
        map.put("name", "张飞");
        map.put("job","Java开发工程师");
        map.put("salary",15000);
        int i = session.update("EmpMapper.insert2", map);//update("定位标识", 参数名);
        System.out.println(i+"行受到了影响");


    }
    /**新增员工信息:用pojo进行封装*/
    @Test
    public void testInsert3(){
       Emp emp =new Emp();
       emp.setName("关羽");
       emp.setJob("保安");
       emp.setSalary(8000d);
        int i = session.update("EmpMapper.insert3", emp);
        System.out.println(i+"行受到了影响");
    }
    /**修改员工信息:关羽 为程序员 薪资为 3400*/
    @Test
    public void testUpdate2(){
        Map<String,Object> map=new HashMap<>();
        map.put("name", "关羽");
        map.put("job","程序员");
        map.put("salary",3400);
        int rows = session.update("EmpMapper.update2",map);
        System.out.println(rows+"行修改成功!");

    }
    /**修改员工信息:用pojo进行封装*/
    @Test
    public void testupdate3(){
        Emp emp =new Emp();
        emp.setName("刘德华");
        emp.setJob("保安");
        emp.setSalary(8000d);
        int i = session.update("EmpMapper.update3", emp);
        System.out.println(i+"行受到了影响");
    }

    /**删除员工信息:刘德华 */
    @Test
    public void testDelete2(){
        Integer id=16;
        int rows = session.update("EmpMapper.delete2",id);
        System.out.println(rows+"行删除成功!");

    }
}








