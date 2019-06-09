package cn.yb.spring.test;

import cn.yb.spring.service.IUserService;
import cn.yb.spring.factory.MyBeanFactory;
import cn.yb.spring.service.StudentService;
import org.junit.Test;

public class test_aspect {
    /**
     * 自己实现 AOP 编程：使用 JDK 代理来实现
     */
    @Test
    public void test1() {
        IUserService userService = MyBeanFactory.createUserService();
        //userService.deleteUser();
        userService.deleteUser(10);
    }
    /**
     * 实现 AOP 编程：使用 cglib 代理来实现
     */
    @Test
    public void test2() {
        StudentService studentService = MyBeanFactory.createStudentService();
        //studentService.deleteStudent();
        studentService.deleteStudent(10);
    }
}
