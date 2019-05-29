package cn.yb.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("forward_and_redirect")
public class AnotherC_ForwardandRedirect {

    @RequestMapping("another_forwardlist")
    public String list(){
        return "/user/info";
    }

}
