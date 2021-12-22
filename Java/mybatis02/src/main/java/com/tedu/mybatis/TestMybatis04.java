package com.tedu.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * Mapper接口开发
 * <p>
 * 1.创建一个mapper接口，要求接口的全限定类名和mapper文件的namespace值相同
 * 2.mapper文件中的每一个SQL语句,在mapper接口要添加一个对应的方法,并且接口中的方法名和SQL标签上的Id值要相同
 * 3.mapper接口中方法上的参数类型和SQL标签上的resultType即返回类型也要相同
 * 4.接口中,方法的返回值类型和SQL标签上的resultType即返回值类型也要相同(
 * 如果方法返回的是一个集合,例如List<Emp>,在resultType中只需要指定集合中的泛型,即Emp类型)
 */

public class TestMybatis04 {
    static SqlSession sqlSession = null;

    static {

        try {

            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//基build()里的配置信息于创建一个对象
            sqlSession = sqlSessionFactory.openSession(true);//用这个对象去自动处理这个事务
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}






