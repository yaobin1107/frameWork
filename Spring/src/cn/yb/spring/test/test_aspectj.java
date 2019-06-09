package cn.yb.spring.test;

import cn.yb.spring.service.IUserService;
import cn.yb.spring.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_aspectj {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_aspectj.xml");
        IUserService userService = (IUserService) context.getBean("userService");
        userService.deleteUser(10);
    }
}
