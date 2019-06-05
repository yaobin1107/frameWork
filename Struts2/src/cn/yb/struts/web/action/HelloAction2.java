package cn.yb.struts.web.action;

import com.opensymphony.xwork2.Action;

/**
 * Action的第二种写法
 * 实现Action接口（com.opensymphony.xwork2.Action）
 * 重写其中的execute方法
 * struts.xml中action没有配置method会默认执行Action的execute方法
 */
public class HelloAction2 implements Action {

    @Override
    public String execute() throws Exception {
        System.out.println("Action的execute方法被调用了！");
        return "success";
    }

    /**
     * Action的第二种写法
     * 实现Action接口（com.opensymphony.xwork2.Action）
     * 返回常量
     */
    public String thirdMethod() {
        return SUCCESS;
    }
}
