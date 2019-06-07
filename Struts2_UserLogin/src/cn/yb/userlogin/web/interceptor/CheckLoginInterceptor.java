package cn.yb.userlogin.web.interceptor;

import cn.yb.userlogin.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 校验登陆拦截器
 */
public class CheckLoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //获取session的user
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        //判断
        if (user != null) {
            return actionInvocation.invoke();//放行
        }
        //没有登陆，返回登录
        return "toLoginPage";
    }
}
