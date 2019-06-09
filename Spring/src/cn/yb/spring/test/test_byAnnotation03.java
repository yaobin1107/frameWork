package cn.yb.spring.test;

import cn.yb.spring.model.User;
import cn.yb.spring.web.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_byAnnotation03 {


    @Test
    public void test1() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_byAnnotation03.xml");

        //配置注解后的开发流程
        //1.获取action(没有配置id，直接类类型获取对象)
        UserAction userAction1 = applicationContext.getBean(UserAction.class);
        //2.创建参数对象，调用action的方法
        User user = new User();
        user.setUsername("yb");
        user.setPassword("123");
        userAction1.save(user);

        UserAction userAction2 = applicationContext.getBean(UserAction.class);
        //默认是单例，地址相同
        //在类上配置 @Scope("prototype") 后是多例，地址不同
        System.out.println(userAction1);
        System.out.println(userAction2);

        applicationContext.getClass().getMethod("close").invoke(applicationContext);
    }
}
