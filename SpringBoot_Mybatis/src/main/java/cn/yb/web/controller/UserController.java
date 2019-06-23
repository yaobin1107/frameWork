package cn.yb.web.controller;

import cn.yb.model.User;
import cn.yb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * _@RestController一般用于写API，给移动客户端提供接口数据，返回JSON数据
 * _@Controller一般用于写后台（有页面）
 */
@RestController//声明rest风格的控制器
@EnableAutoConfiguration//自动配置，相当于写了spring的配置文件
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("register")
    @ResponseBody
    public String register(String username, String password) {
        userService.register(username, password);
        return "success";
    }

    @RequestMapping("find")
    @ResponseBody
    public User findUserByUsername(String username) {
        return userService.findUserByUsername(username);
    }

}
