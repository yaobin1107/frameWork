package cn.yb.spring.test;

import cn.yb.spring.model.User;
import cn.yb.spring.service.IUserService;
import cn.yb.spring.service.impl.UserServiceImpl;
import cn.yb.spring.web.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_byAnnotation02 {


    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_byAnnotation02.xml");

        //Web开发流程：action->service->dao
        UserAction userAction = (UserAction) applicationContext.getBean("userAction");

        User user = new User();
        user.setPassword("123");
        user.setUsername("yb");
        userAction.save(user);
    }
}
