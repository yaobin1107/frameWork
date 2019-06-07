package cn.yb.userlogin.web.action;

import cn.yb.userlogin.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    public String login() {
        //接收请求参数
        //判断登陆成功与否
        if ("yb".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            //登陆成功将User保存到session
            ServletActionContext.getRequest().getSession().setAttribute("user", user);
            return SUCCESS;
        }
        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }
}
