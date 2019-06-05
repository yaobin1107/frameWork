package cn.yb.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletAction2 extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    HttpServletResponse response;
    HttpServletRequest request;

    public String test() {
        //获取Servlet的api[request,response,session,application（ServletContext)]的方式
        //第二种方式：通过实现接口，让Struts自动注入进来
        System.out.println(request);
        System.out.println(response);
        return NONE;//不用跳转
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
