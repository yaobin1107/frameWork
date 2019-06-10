package cn.yb.mybatis.test;

import cn.yb.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class test_select {

    @Test
    public void test1() throws Exception {
        //a)读取配置文件(官方文档中有说明)
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // c)通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        /*
        d)调用SqlSession的操作数据库方法
        selectOne(String s , Object o)
        String s:映射文件中标签上的id
        Object o:传入的参数
        返回值类型：映射文件中标签上resultType的类型
        */
        //查询一条结果
        //User user = sqlSession.selectOne("findUserById", 10);
        //查询多条结果
        List<User> users = sqlSession.selectList("findUserByName", "张");
        System.out.println(users);
        //e)关闭SqlSession
        sqlSession.close();
    }
}
