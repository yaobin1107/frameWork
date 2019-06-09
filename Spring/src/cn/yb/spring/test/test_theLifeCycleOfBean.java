package cn.yb.spring.test;

import cn.yb.spring.model.User;
import cn.yb.spring.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_theLifeCycleOfBean {

    /**
     * Bean的生命周期
     */
    @Test
    public void test1() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_life.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
        //关闭容器
        applicationContext.getClass().getMethod("close").invoke(applicationContext);
    }
}
