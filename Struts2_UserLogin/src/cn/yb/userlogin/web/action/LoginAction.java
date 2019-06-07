package cn.yb.userlogin.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;

public class LoginAction extends ActionSupport {

    private String username;
    private String password;

    public void setUsername(String usernmae) {
        this.username = usernmae;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(username);
        System.out.println(password);
        return super.execute();
    }
}
