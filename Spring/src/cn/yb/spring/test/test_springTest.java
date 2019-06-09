package cn.yb.spring.test;


import cn.yb.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations={"classpath:beans_accountTranser_AOP.xml"})//加载spring配置文件
public class test_springTest {

    @Autowired//自动注入
    private IAccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("rose","jack",1000);
    }
}
