package cn.yb.edu.web.controller;

import cn.yb.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private IUserService userService;

    @RequestMapping("manage")
    public String manage() {
        return "department/manage";
    }

    @RequestMapping("info")
    public String info() {
        return "department/info";
    }

    @RequestMapping("update")
    public String update() {
        return "department/update";
    }

    @RequestMapping("edit")
    public String edit() {
        return "department/edit";
    }
}
