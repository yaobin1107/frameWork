package cn.yb.spring.test;

import cn.yb.spring.service.IUserService;
import cn.yb.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_byAnnotation {

    /**
     * 注解来取代xml中bean的配置
     * 1.Spring默认情况下注解不生效，需要开启注解功能
     * 2.如何开启Spring注解功能?（在xml中配置下面两行代码）
     * <!--开启注解功能-->
     * <context:annotation-config/>
     * <!--扫描注解的位置-->
     * <context:component-scan base-package="cn.yb.spring"/>
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_byAnnotation.xml");

        /**
         * 如果@Component("userService")后面配置了 id 则通过id类获取
         * IUserService service = applicationContext.getBean("userService");
         * 如果@Component后面没有配置 id 则通过类类型(或者接口类型)来获取
         * IUserService service = applicationContext.getBean(UserServiceImpl.class);
         */
        IUserService service = applicationContext.getBean(UserServiceImpl.class);
        service.add();
    }
}
