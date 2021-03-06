package cn.yb.edu.web.controller;

import cn.yb.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IUserService userService;

    @RequestMapping("manage")
    public String manage() {
        return "order/manage";
    }

    @RequestMapping("info")
    public String info() {
        return "order/info";
    }

    @RequestMapping("update")
    public String update() {
        return "order/update";
    }

    @RequestMapping("edit")
    public String edit() {
        return "order/edit";
    }
}
