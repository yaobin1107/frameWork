package cn.yb.spring.aspect;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类：增强代码与切入点的结合
 */
public class MyAspect_AOP implements MethodInterceptor {
    public void before() {
        System.out.println("开启事务");
    }

    public void after() {
        System.out.println("提交事务");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //拦截方法
        System.out.println("开启事务！");
        //放行方法
        Object retObj = methodInvocation.proceed();
        System.out.println("提交事务！");
        return retObj;
    }
}
