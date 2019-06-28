package cn.yb.web.controller;

import cn.yb.mybatis1.service.UserServiceImpl;
import cn.yb.mybatis2.service.CustomerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * _@RestController一般用于写API，给移动客户端提供接口数据，返回JSON数据
 * _@Controller一般用于写后台（有页面）
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    //@Autowired
    //private CustomerServiceImpl customerService;

    //Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("register")
    @ResponseBody
    public String register(String username, String password) {
        //记录客户端你请求参数
        //logger.info("username:" + username + "password:" + password);
        //把数据存到mybatis1数据库
        userService.save(username, password);
        //把数据存到mybatis2数据库
        //customerService.save(username, "12345678910");
        return "success";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password) {
        return "success";
    }


}
