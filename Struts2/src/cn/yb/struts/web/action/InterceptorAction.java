package cn.yb.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class InterceptorAction extends ActionSupport {

    public String testMyInterceptor() {

        return SUCCESS;
    }
}
