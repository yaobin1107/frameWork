package cn.yb.spring.test;

import cn.yb.spring.service.IAccountService;
import cn.yb.spring.service.impl.AccountServiceImpl;
import cn.yb.spring.service.impl.AccountServiceImpl_Anno;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_account {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_accountTranser.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        accountService.transfer("jack","rose",1000);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_accountTranser02.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService02");
        accountService.transfer("jack","rose",1000);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_accountTranser03.xml");
        IAccountService accountService = (IAccountService) context.getBean("proxyService");
        accountService.transfer("jack","rose",1000);
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_accountTranser_AOP.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService04");
        accountService.transfer("rose","jack",1000);
    }

    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_accountTranser_Anno.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService05");
        accountService.transfer("rose","jack",1000);
    }
}
