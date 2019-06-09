package cn.yb.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect_Aspectj {
    public void myBefore(JoinPoint jp) {
        //System.out.println(jp.getSignature().getName());//连接点的方法名
        System.out.println("前置通知");
    }
    /**
     * 后置通知获取 Service 方法执行后的返回值
     * Object retValue：Service 方法执行后的返回值
     * 如果定义了返回值参数，需要在 xml 中配置 returning
     */
    public void myAfterReturning(JoinPoint jp, Object retValue) {
        System.out.println("后置通知");
    }
    public Object myArround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知_开启事务");
        //放行
        Object retObj = joinPoint.proceed();
        System.out.println("环绕通知_提交事务");
        return retObj;
    }
    public void myAfterThrowing(JoinPoint jp, Throwable e) {
        //Throwable e 异常对象
        System.out.println("异常通知");
    }
    public void myAfter(JoinPoint jp) {
        System.out.println("最终通知");
    }
}
