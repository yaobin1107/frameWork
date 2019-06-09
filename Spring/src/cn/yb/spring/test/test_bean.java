package cn.yb.spring.test;

import cn.yb.spring.service.IUserService;
import cn.yb.spring.service.UserServiceFactory;
import cn.yb.spring.service.UserServiceFactory2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_bean {

    /**
     * 装配bean的三种方式，装配bean指的是在xml里面配置一个bean标签
     */
    @Test
    public void test1() {
        //第一种方式：new 一个实现类
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("beans.xml");
        IUserService userService1 = (IUserService) applicationContext1.getBean("userService1");
        userService1.add();

        //第二种方式：通过静态工厂方法
        //通过bean
        //ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("beans.xml");
        //IUserService userService2 = (IUserService) applicationContext2.getBean("userService2");
        //userService2.add();

        //第三种方式：通过实例工厂方法
        //通过bean
        //ApplicationContext applicationContext3 = new ClassPathXmlApplicationContext("beans.xml");
        //IUserService userService3 = (IUserService) applicationContext3.getBean("userService3");
        //userService3.add();

    }
}
