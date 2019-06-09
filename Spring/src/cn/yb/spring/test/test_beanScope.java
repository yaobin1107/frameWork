package cn.yb.spring.test;

import cn.yb.spring.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_beanScope {

    /**
     * bean的作用域
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_scope.xml");
        IUserService userService1 = (IUserService) applicationContext.getBean("userService");
        IUserService userService2 = (IUserService) applicationContext.getBean("userService");
        //多例情况下，两个bean不一样
        System.out.println(userService1);
        System.out.println(userService2);
    }
}
