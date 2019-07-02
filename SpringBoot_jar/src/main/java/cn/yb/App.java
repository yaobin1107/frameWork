package cn.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动SpringBoot的项目的第二种方式
 */
@EnableAutoConfiguration
//@ComponentScan(basePackages = "cn.yb.web.controller")
//@ComponentScan(basePackages = {"cn.yb.web.controller", "cn.yb.web.exception"})
@ComponentScan(basePackages = {"cn.yb.web", "cn.yb.service"})
public class App {
    public static void main(String[] args) {
        //启动SpringBoot的项目
        SpringApplication.run(App.class, args);
    }
}
