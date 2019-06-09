package cn.yb.spring.test;

import cn.yb.spring.dao.IUserDao;
import cn.yb.spring.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class test_dataBase {


    @Test
    public void test1() {
        //创建数据源
        BasicDataSource dataSource = new BasicDataSource();
        //封装参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //创建jdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //执行sql
        jdbcTemplate.update("update t_user set username = ? where id = ?","yb",1);

    }

    @Test
    public void test2() {
        ApplicationContext context =new ClassPathXmlApplicationContext("beans_dataBase.xml");
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        User user = new User();
        user.setUsername("yb3");
        user.setPassword("123456");
        userDao.add(user);
    }
}
