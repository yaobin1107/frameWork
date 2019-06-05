package cn.yb.struts.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("MyInterceptor1拦截前");
        String returnStr = actionInvocation.invoke();//放行
        //System.out.println("放行的返回值：" + returnStr);
        System.out.println("MyInterceptor1拦截后");
        return returnStr;
    }
}
