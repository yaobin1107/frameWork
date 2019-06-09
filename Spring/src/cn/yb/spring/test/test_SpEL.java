package cn.yb.spring.test;

import cn.yb.spring.model.Customer;
import cn.yb.spring.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_SpEL {

    /**
     * SpEL：Spring表达式
     */
    @Test
    public void test1() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_SpEL.xml");
        Customer customer = (Customer) applicationContext.getBean("customer");
        System.out.println(customer);
        System.out.println(customer.getAddress());
    }
}
