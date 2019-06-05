package cn.yb.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletAction extends ActionSupport {
    public String test() {
        //获取Servlet的api[request,response,session,application（ServletContext)]的方式
        //第一种方式：通过ServletActionContext
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        ServletContext servletContext = ServletActionContext.getServletContext();
        HttpSession session = request.getSession();
        System.out.println(request);
        System.out.println(response);
        System.out.println(servletContext);
        System.out.println(session);
        /*
        org.apache.struts2.dispatcher.StrutsRequestWrapper@145a438c-->属于Struts
        org.apache.catalina.connector.ResponseFacade@3208a6c4      -->属于Tomcat
        org.apache.catalina.core.ApplicationContextFacade@55fca785 -->属于Tomcat
        org.apache.catalina.session.StandardSessionFacade@3e5a38dd -->属于Tomcat
         */
        return NONE;//不用跳转
    }
}
