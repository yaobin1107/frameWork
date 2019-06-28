package cn.yb;

import cn.yb.dbconfig.DBConfig1;
import cn.yb.dbconfig.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动SpringBoot的项目的第二种方式
 */
@EnableAutoConfiguration
/*@ComponentScan(basePackages = {"cn.yb.web", "cn.yb.service",
        "cn.yb.datasource", "cn.yb.mybatis1", "cn.yb.mybatis2",
        "cn.yb.dbconfig"})*/
@ComponentScan(basePackages = "cn.yb")
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
public class App {
    public static void main(String[] args) {
        //启动SpringBoot的项目
        SpringApplication.run(App.class, args);
    }
}
