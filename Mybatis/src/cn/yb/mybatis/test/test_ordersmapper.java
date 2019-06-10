package cn.yb.mybatis.test;

import cn.yb.mybatis.mapper.OrdersMapper;
import cn.yb.mybatis.mapper.UserMapper;
import cn.yb.mybatis.model.Orders;
import cn.yb.mybatis.model.OrdersExt;
import cn.yb.mybatis.model.User;
import cn.yb.mybatis.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class test_ordersmapper {

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
     * 一对一：写个订单扩展类（一个订单属于一个用户）
     */
    @Test
    public void test1() {
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        OrdersExt ordersExt = ordersMapper.findOrderById(3);
        System.out.println("查询的结果是：" + ordersExt);

    }

    /**
     * 一对一：模型里面有模型
     */
    @Test
    public void test2() {
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        Orders order = ordersMapper.findOrderById2(3);
        System.out.println("查询的结果是：" + order);
        System.out.println(order.getUser());
    }

    /**
     * 一对一：模型里面有集合
     */
    @Test
    public void test3() {
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        Orders order = ordersMapper.findOrderById3(3);
        System.out.println("查询的结果是：" + order);
        System.out.println(order.getUser());
        System.out.println(order.getOrderDetails());
    }

    /**
     * 测试懒加载
     */
    @Test
    public void test4() {
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = ordersMapper.findOrderAndUserByLazyLoading();
        for (Orders order : orders) {
            System.out.println("订单信息:"+order);
            System.out.println("订单所属的用户:"+order.getUser());
        }
    }
}
