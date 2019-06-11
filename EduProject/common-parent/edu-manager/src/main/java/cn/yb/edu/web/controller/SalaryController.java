package cn.yb.edu.web.controller;

import cn.yb.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("salary")
public class SalaryController {

    @Autowired
    private IUserService userService;

    @RequestMapping("manage")
    public String manage() {
        return "Salary/manage";
    }

    @RequestMapping("info")
    public String info() {
        return "Salary/Info";
    }

    @RequestMapping("update")
    public String update() {
        return "Salary/Update";
    }

    @RequestMapping("edit")
    public String edit() {
        return "Salary/Edit";
    }
}
