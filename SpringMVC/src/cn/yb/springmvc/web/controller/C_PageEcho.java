package cn.yb.springmvc.web.controller;

import cn.yb.springmvc.model.User;
import cn.yb.springmvc.model.UserExt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class C_PageEcho {

    @RequestMapping("/pageecho")
    public String list(Model model) {
        //BindingAwareModelMap
        //System.out.println(model.getClass());
        //1. 模拟数据库数据
        List<User> userList = new ArrayList<User>();

        User user1 = new User(1, "yb1", "123", "male");
        User user2 = new User(2, "yb2", "1234", "famale");
        User user3 = new User(3, "yb3", "12345", "male");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        //2. 将数据存进Model
        model.addAttribute("userList", userList);

        return "/user/userList";
    }

    @RequestMapping("edit")
    public String edit(int id, Model model) {
        System.out.println("id:" + id);
        //通过id查询数据库返回User对象
        User user = new User(1, "yb1", "123", "male");//假装查询数据库
        model.addAttribute("user", user);
        return "/user/userEdit";
    }

    //URL模板映射
    @RequestMapping("edit1/{id}")
    public String edit1(@PathVariable int id, Model model) {
        System.out.println("id:" + id);
        //通过id查询数据库返回User对象
        User user = new User(1, "yb1", "123", "male");//假装查询数据库
        model.addAttribute("user", user);
        return "/user/userEdit";
    }

    @RequestMapping("update")
    public String update(int id, Model model) {
        System.out.println("id:" + id);
        //通过id查询数据库返回User对象
        List<User> userList = new ArrayList<>();

        User user1 = new User();
        User user2 = new User(2, "yb2", "1234", "famale");
        User user3 = new User(3, "yb3", "12345", "male");
        user1.setUsername("newyb");
        user1.setGender("newgender");
        user1.setPassword("newPassword");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        model.addAttribute("userList", userList);

        return "/user/userList";
    }
}
