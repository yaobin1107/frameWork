package cn.yb.spring.test;

import cn.yb.spring.service.IUserService;
import cn.yb.spring.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_aspectAOP {

    /**
     * 获取Spring容器中的代理对象（半自动）
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_AOP.xml");
        IUserService userService = (IUserService) context.getBean("proxyService");
        userService.deleteUser(10);
        /* 结果：
            开启事务！
            通过id删除用户_deleteUser(int id)
            提交事务！
         */
    }

    /**
     * 获取Spring容器中的代理对象（全自动）
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_AOP2.xml");
        IUserService userService = (IUserService) context.getBean("userService");
        userService.deleteUser(10);
        /* 结果：
            开启事务！
            通过id删除用户_deleteUser(int id)
            提交事务！
         */
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.deleteStudent(10);
        /* 结果：
            开启事务！
            通过id删除学生_ deleteStudent(int id)
            提交事务！
        */
    }
}
