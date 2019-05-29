package cn.yb.springmvc.web.controller;

import cn.yb.springmvc.model.User;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandController extends AbstractCommandController {

    public CommandController() {
        //告诉SpringMVC把表单数据存在User模型里面去
        this.setCommandClass(User.class);
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response,
                                  Object o, BindException e) throws Exception {
        User user = (User) o;
        System.out.println(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/info");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
