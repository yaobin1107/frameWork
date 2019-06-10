package cn.yb.mybatis.test;

import cn.yb.mybatis.mapper.UserMapper;
import cn.yb.mybatis.model.OrderDetail;
import cn.yb.mybatis.model.Orders;
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

public class test_usermapper {

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

    @Test
    public void test1() {
        //Object object = sqlSession.getMapper(UserMapper.class);
        //System.out.println(object);org.apache.ibatis.binding.MapperProxy@3ab800d7
        //返回代理类型，可以直接转为UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findUserById(10));
    }

    @Test
    public void test2() {
        User user = new User("yb2", "2", new Date(), "西安");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.save(user);
        sqlSession.commit();
    }

    @Test
    public void test3() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //通过模型的包装类查询用户
        UserQueryVO userQueryVO = new UserQueryVO();

        User user = new User();
        user.setId(1);

        userQueryVO.setUser(user);

        System.out.println(userMapper.findUserByUserQueryVo(userQueryVO));
    }

    @Test
    public void test4() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //通过Map查询用户
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("address", "西");
        map.put("sex", "2");

        List<User> users = userMapper.findUserByMap(map);
        System.out.println(users);
    }

    @Test
    public void test5() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //通过模型包装类查询用户
        UserQueryVO userQueryVO = new UserQueryVO();
        User user = new User();
        user.setSex("1");//男性
        userQueryVO.setUser(user);
        int userCount = userMapper.findUserCount(userQueryVO);
        System.out.println("男性用户个数：" + userCount);
    }

    /**
     * 结果类型为resultMap
     */
    @Test
    public void test6() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdResultMap(10);
        System.out.println("查找的用户是：" + user);
        //打印出结果：查找的用户是：null
        //因为查询出的字段取了别名，与数据库表中名称不一样，所以返回null
        //这时候需要配置resultMap
    }

    //if 和 where
    @Test
    public void test7() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询条件
        UserQueryVO userQueryVO = new UserQueryVO();
        User user = new User();
        user.setSex("1");
        user.setUsername("张");
        userQueryVO.setUser(user);
        List<User> userList = userMapper.findUserList(userQueryVO);
        System.out.println("查询的结果是：" + userList);
    }

    //foreach 传入参数是包装类
    @Test
    public void test8() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询条件
        UserQueryVO userQueryVO = new UserQueryVO();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        userQueryVO.setIds(ids);
        List<User> users = userMapper.findUserByIds(userQueryVO);
        System.out.println("查询的结果是：" + users);
    }

    //foreach 传入参数是集合
    @Test
    public void test9() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询条件
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        List<User> users = userMapper.findUserByIds2(ids);
        System.out.println("查询的结果是：" + users);
    }

    /**
     * 多对多：查询用户信息及用户购买的商品信息
     */
    @Test
    public void test10() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserAndOrderInfo();
        for (User user : users) {
            System.out.println("用户信息：" + user);
            System.out.println("---------------------------------------------");
            for (Orders orders : user.getOrderList()) {
                System.out.println("订单信息：" + orders);
                System.out.println("---------------------------------------------");
                for (OrderDetail orderDetail : orders.getOrderDetails()) {
                    System.out.println("订单详情：" + orderDetail);
                    System.out.println("商品信息：" + orderDetail.getItems());
                }
                System.out.println("---------------------------------------------");
            }
        }
    }
}
