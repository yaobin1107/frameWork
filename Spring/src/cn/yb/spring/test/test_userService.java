package cn.yb.spring.test;

import cn.yb.spring.service.IUserService;
import cn.yb.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class test_userService {

    @Test
    public void test1() {
        //使用UserService方式从Spring容器获取
        //1.加载beans.xml，spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //2.从spring容器获取userService对象
        IUserService userService1 = (IUserService) applicationContext.getBean("userService");
        userService1.add();
        IUserService userService2 = (IUserService) applicationContext.getBean("userService");
        userService2.add();
        System.out.println(userService1);
        System.out.println(userService2);//打印出的结果，两个是同一个对象
    }

    /**
     * Spring容器的三种加载方式：
     * 1.ClassPathXmlApplicationContext：ClassPath类路径加载，指的就是classes路径（最常用）
     * 2.FileSystemXmlApplicationContext：文件系统路径获取配置文件
     * 3.使用BeanFactory(了解一下即可)
     */
    /**
     * BeanFactory 和 ApplicationContext 对比
     *  BeanFactory 采取延迟加载，第一次 getBean 时才会初始化 Bean
     *  ApplicationContext(即时加载) 是对 BeanFactory 扩展，提供了更多功能
     *       国际化处理
     *       事件传递
     *       Bean自动装配
     *       各种不同应用层的Context实现
     */
    @Test
    public void test2() {
        //第一种：ClassPathXmlApplicationContext：ClassPath类路径加载，指的就是classes路径（最常用）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //第二种：FileSystemXmlApplicationContext：文件系统路径获取配置文件
        //ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\idea_frameWork\\Spring\\src\\beans.xml");

        //第三种：使用BeanFactory(了解一下即可)
        //String path = "D:\\idea_frameWork\\Spring\\src\\beans.xml";
        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(path));
        //IUserService userService = (IUserService) beanFactory.getBean("userService");
        //userService.add();

        IUserService userService = (IUserService) applicationContext.getBean("userService");
        userService.add();
    }
}
