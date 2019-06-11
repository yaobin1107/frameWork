package cn.yb.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request) {
        if ("yb".equals(username) && "123".equals(password)) {
            //1.登陆成功保存session
            request.getSession().setAttribute("user",username);
            //2.进入主页面
            return "main";
        }
        return "login";
    }
}
