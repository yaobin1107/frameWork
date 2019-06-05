package cn.yb.struts.web.action;

import cn.yb.struts.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求参数的几种方式：
 * 第一种方式：通过request对象
 * HttpServletRequest request = ServletActionContext.getRequest();
 * String username = request.getParameter("username");
 * String password = request.getParameter("password");
 * 第二种方式：通过属性set注入
 * 提供属性的set方法即可
 * 第三种方式：通过模型属性set注入
 * 提供模型属性的set方法即可
 * 第四种：通过模型驱动，在action里实现一个模型驱动接口
 * 通过这种方式在jsp中不用写user.username
 * 实现步骤：
 * 1.实现ModelDriver接口
 * 2.提供模型属性，并一定要赋值（实例化）
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {
    //第三种：
    /*private User user;
    public User getUser() {
        System.out.println("getUser");
        return user;
    }
    public void setUser(User user) {
        System.out.println("setUser");
        this.user = user;
    }*/

    //第二种：
    /*private String username;
    private String password;

    public void setPassword(String password) {
        System.out.println("setPassword");
        this.password = password;
    }

    public void setUsername(String username) {
        System.out.println("setUsername");
        this.username = username;
    }*/

    //第一种方式：通过request对象
    /*HttpServletRequest request = ServletActionContext.getRequest();
    String username = request.getParameter("username");
    String password = request.getParameter("password");*/

    public String login() {
        System.out.println(user);
        return NONE;
    }

    //第四种：模型驱动
    //注意：一定要实例化模型
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }
}
