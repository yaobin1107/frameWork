package cn.yb.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解的几种写法：
 * 1.@RequestMapping(“list”)
 * 2.@RequestMapping(“/list.do”)
 * 3.@RequestMapping(value=”/list.do”)
 * 4.@RequestMapping(value = "/list3",method=RequestMethod.POST) 只能使用POST方法
 * 5.@RequestMapping(value = "/list3",method=RequestMethod.Get) 只能使用GET方法
 */

@Controller
@RequestMapping("/user")//自定义根路径，可以不写，不写是直接访问方法上的路径，写上则访问自定义根路径加上方法上的路径
public class C_UseAnnotation {


    @RequestMapping("/add")
    public String userAdd() {
        return "/user/userAdd";
    }

    @RequestMapping("/info")
    public String info() {
        return "/user/info";
    }


    @RequestMapping("/list")
    public String userList() {
        return "/user/userList";
    }

}

