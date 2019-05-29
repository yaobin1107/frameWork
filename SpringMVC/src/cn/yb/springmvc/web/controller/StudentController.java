package cn.yb.springmvc.web.controller;

import cn.yb.springmvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("stu")
public class StudentController {

    @RequestMapping("toRegister")
    public String toRegister() {
        return "/stu/register";
    }

    /**
     * 请求和响应都是json格式数据：
     * RequestBody：把json数据转为模型对象
     * ResponseBody：返回json数据，把对象转为json字符串返回客户端
     */
    @RequestMapping("save")
    public @ResponseBody
    Student save(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

    /**
     * 只有响应是json格式数据：
     * ResponseBody：返回json数据，把对象转为json字符串返回客户端
     */
    @RequestMapping("save1")
    public @ResponseBody
    Student save1(Student student) {
        System.out.println(student);
        return student;
    }

    @RequestMapping("get")
    public Student get() {
        Student student = new Student();
        student.setName("yb");
        student.setSex("男");
        return student;
    }
}
