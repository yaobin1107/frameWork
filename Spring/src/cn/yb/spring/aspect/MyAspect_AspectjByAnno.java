package cn.yb.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect_AspectjByAnno {

    /**
     * 声明一个公共切入点
     */
    @Pointcut("execution(* cn.yb.spring.service.impl.UserServiceImpl.*(..))")
    public void myPointcut() {
    }

    @Before("execution(* cn.yb.spring.service.impl.UserServiceImpl.*(..))")
    public void myBefore(JoinPoint jp) {
        //System.out.println(jp.getSignature().getName());//连接点的方法名
        System.out.println("前置通知");
    }

    /**
     * 后置通知获取 Service 方法执行后的返回值
     * Object retValue：Service 方法执行后的返回值
     * 如果定义了返回值参数，需要在 xml 中配置 returning
     *
     * @param jp
     */

    @AfterReturning(pointcut = "myPointcut()", returning = "retValue")//这里使用了公共切入点
    public void myAfterReturning(JoinPoint jp, Object retValue) {
        //System.out.println(jp.getSignature().getName());//连接点的方法名
        //System.out.println("返回值：" + retValue);
        System.out.println("后置通知");
    }

    @Around("myPointcut()")
    public Object myArround(ProceedingJoinPoint joinPoint) throws Throwable {
        //System.out.println("joinPoint:" + joinPoint.getSignature().getName());//业务方法名
        System.out.println("环绕通知_开启事务");
        //放行
        Object retObj = joinPoint.proceed();
        System.out.println("环绕通知_提交事务");
        return retObj;
    }

    @AfterThrowing(value = "myPointcut()", throwing = "e")
    public void myAfterThrowing(JoinPoint jp, Throwable e) {
        //System.out.println(jp.getSignature().getName());//异常的方法名
        //Throwable e 异常对象
        System.out.println("异常通知");
    }

    @After("myPointcut()")
    public void myAfter(JoinPoint jp) {
        //System.out.println(jp.getSignature().getName());//连接点的方法名
        System.out.println("最终通知");
    }
}
