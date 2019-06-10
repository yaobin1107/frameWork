package cn.yb.mybatis.test;

import cn.yb.mybatis.mapper.UserMapper;
import cn.yb.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class test_cache {

    /**
     * 测试缓存：一级缓存
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //a)读取配置文件(官方文档中有说明)
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // c)通过SqlSessionFactory创建SqlSession会话
        SqlSession sqlSession = sessionFactory.openSession();
        // d)通过会话获取dao接口(Mapper)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        /**
         * 默认情况下，一级缓存是开启的（sqlSession级别缓存）
         */
        User user1 = userMapper.findUserById(1);
        System.out.println("user1:" + user1);

        //保存用户(当有对数据库的修改，删除，添加时，一级缓存会自动清除)
        userMapper.save(new User("yb_cache", "2", new Date(), "西安"));

        User user2 = userMapper.findUserById(1);
        System.out.println("user2:" + user2);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试缓存：二级缓存
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //a)读取配置文件(官方文档中有说明)
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // c)通过SqlSessionFactory创建SqlSession会话
        SqlSession sqlSession1 = sessionFactory.openSession();
        SqlSession sqlSession2 = sessionFactory.openSession();
        SqlSession sqlSession3 = sessionFactory.openSession();

        // d)通过会话获取dao接口(Mapper)
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);

        /**
         * 默认情况下，二级缓存是关闭的，需要手动开启（全局配置文件+映射文件）
         */

        User user1 = userMapper1.findUserById(1);
        System.out.println("user1:" + user1);
        //注意：session关闭后，才会提交到二级缓存
        sqlSession1.close();

        //保存用户(当有对数据库的修改，删除，添加时，二级缓存会自动清除)
        userMapper3.save(new User("yb_cache", "2", new Date(), "西安"));
        sqlSession3.commit();
        sqlSession3.close();

        User user2 = userMapper2.findUserById(1);
        System.out.println("user2:" + user2);
        sqlSession2.close();

    }
}
