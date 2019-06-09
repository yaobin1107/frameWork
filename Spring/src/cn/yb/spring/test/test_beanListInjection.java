package cn.yb.spring.test;

import cn.yb.spring.model.Programmer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_beanListInjection {

    /**
     * bean的集合注入
     */
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_listInjection.xml");
        Programmer programmer = (Programmer) applicationContext.getBean("programmer");
        System.out.println("车：" + programmer.getCars());
        System.out.println("宠物：" + programmer.getPets());
        System.out.println("个人信息：" + programmer.getInfos());
        System.out.println("数据库链接信息：" + programmer.getMysqlInfo());
        for (String members : programmer.getMembers()) {
            System.out.println("家庭成员：" + members);
        }
    }
}
