package cn.yb.edu.web.controller;

import cn.yb.edu.model.User;
import cn.yb.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login() {
        System.out.println("测试");
        return "Default";
    }

    @RequestMapping("find")
    public String find(Integer id) {
        User user = userService.findById(id);
        System.out.println(user);
        return null;
    }

    @RequestMapping("manage")
    public String manage() {
        return "User/Manage";
    }

    @RequestMapping("info")
    public String info() {
        return "User/Info";
    }

    @RequestMapping("update")
    public String update() {
        return "User/Update";
    }

    @RequestMapping("edit")
    public String edit() {
        return "User/Edit";
    }
}
