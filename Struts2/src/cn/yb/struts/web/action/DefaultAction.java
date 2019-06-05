package cn.yb.struts.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action的第三种写法
 * 继承ActionSupport类（com.opensymphony.xwork2.Action）
 * struts.xml中action没有配置method会默认执行其父类ActionSupport的execute方法
 * 一般这种方法最常用！
 */
public class DefaultAction implements Action {

    @Override
    public String execute() throws Exception {
        System.out.println("DefaultAction");
        return SUCCESS;
    }
}
