package cn.yb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "cn.yb")
@MapperScan(basePackages = "cn.yb.mapper")
public class App {
    public static void main(String[] args) {
        //启动SpringBoot的项目
        SpringApplication.run(App.class, args);
    }
}
