package cn.yb.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//声明rest风格的控制器
@EnableAutoConfiguration//自动配置，相当于写了spring的配置文件
public class HelloController2 {

    @RequestMapping("hello/{name}")
    @ResponseBody//将return的数据转成json
    public String hello(@PathVariable() String name) {
        return name + ":hello,springboot";
    }

    /*public static void main(String[] args) {
        //启动springboot的项目
        SpringApplication.run(HelloController2.class, args);
    }*/
}
