package cn.yb.edu.web.controller;

import cn.yb.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IUserService userService;

    @RequestMapping("manage")
    public String manage() {
        return "employee/manage";
    }

    @RequestMapping("info")
    public String info() {
        return "employee/info";
    }

    @RequestMapping("update")
    public String update() {
        return "employee/update";
    }

    @RequestMapping("edit")
    public String edit() {
        return "employee/edit";
    }
}
