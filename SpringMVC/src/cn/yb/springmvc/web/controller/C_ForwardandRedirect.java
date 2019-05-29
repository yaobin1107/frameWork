package cn.yb.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class C_ForwardandRedirect {

    @RequestMapping("forwardlist")
    public String list() {
        return "/user/register";
    }

    @RequestMapping("testForward1")
    public String testForward1() {
        //同一个控制器转发
        return "forward:forwardlist.do";
    }

    @RequestMapping("testForward2")
    public String testForward2() {
        //不同控制器转发
        //"forward:/另一个控制器自定义根路径/另一个控制器方法上的根路径"
        return "forward:/forward_and_redirect/another_forwardlist.do";
    }

    @RequestMapping("testRedirect1")
    public String testRedirect1() {
        //同一个控制器转发
        return "redirect:forwardlist.do";
    }

    @RequestMapping("testRedirect2")
    public String testRedirect2() {
        //不同控制器转发
        //"forward:/另一个控制器自定义根路径/另一个控制器方法上的根路径"
        return "redirect:/forward_and_redirect/another_forwardlist.do";
    }
}
