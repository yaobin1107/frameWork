package cn.yb.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@RequestMapping("tea")
public class TeacherController {

    @RequestMapping("list")
    public String list() {
        return "teacher/list";
    }

    public static void main(String[] args) {
        SpringApplication.run(TeacherController.class, args);
    }
}
