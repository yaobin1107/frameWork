package cn.yb.mybatis.test;

import cn.yb.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class test_insert {

    SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        //a)读取配置文件(官方文档中有说明)
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // c)通过SqlSessionFactory创建SqlSession
        sqlSession = sessionFactory.openSession();
    }

    @After
    public void after() {
        //关闭session
        sqlSession.close();
    }

    /**
     * 插入数据
     */
    @Test
    public void test1() {
        User user = new User("yb", "2", new Date(), "西安");
        sqlSession.insert("insertUser", user);//返回值是受影响行数
        //除了查询之外，其他操作需要事务提交（默认不自动提交）
        sqlSession.commit();
    }

    /**
     * 插入数据后，返回模型自增主键
     */
    @Test
    public void test2() {
        User user = new User("yb1", "2", new Date(), "西安");
        sqlSession.insert("insertUser2", user);//返回值是受影响行数
        //除了查询之外，其他操作需要事务提交（默认不自动提交）
        sqlSession.commit();
        System.out.println("插入用户的ID:" + user.getId());
        //打印出0，修改配置文件后返回真实id
    }
}
