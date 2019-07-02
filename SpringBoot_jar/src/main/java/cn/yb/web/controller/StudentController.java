package cn.yb.web.controller;

import cn.yb.model.Student;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller//声明rest风格的控制器
@EnableAutoConfiguration//自动配置，相当于写了spring的配置文件
@RequestMapping("stu")
public class StudentController {

    @RequestMapping("list")
    public String list(Model model) {

        model.addAttribute("username", "yb");
        model.addAttribute("age", 40);

        List<Student> stuList = new ArrayList<Student>();
        stuList.add(new Student(1001,"zhangsan","男"));
        stuList.add(new Student(1002,"lisi","男"));
        stuList.add(new Student(1003,"wangwu","女"));

        model.addAttribute("stuList", stuList);

        return "stu/list";//找模板页面
    }
}
