package cn.yb.spring.test;

import cn.yb.spring.model.Student;
import cn.yb.spring.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_property {

    /**
     * 给对象属性赋值的几种方式（手动注入）：
     * 1.通过构造方法
     * 2.通过属性的set方法注入
     * 3.通过 p 命名空间注入(了解)
     */
    @Test
    public void test1() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_property.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
