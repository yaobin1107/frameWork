package cn.yb.spring.factory;

import cn.yb.spring.aspect.MyAspect;
import cn.yb.spring.service.IUserService;
import cn.yb.spring.service.StudentService;
import cn.yb.spring.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyBeanFactory {

    /**
     * JDK 生成代理实现 AOP 编程
     * 方法返回值是业务方法的返回值（代理对象）
     */
    public static IUserService createUserService() {
        //1.创建目标对象 target
        final IUserService userService = new UserServiceImpl();//内部类访问局部变量，变量要加final
        //2.声明切面类
        final MyAspect myAspect = new MyAspect();
        //3.把切面类的方法应用到目标类
        //3.1.创建jdk代理（拦截方法）
        /*  newProxyInstance(ClassLoader loader,//类加载器，写当前类
                          Class<?>[] interfaces,//接口,接口的方法会被拦截
                          InvocationHandler h)  //处理
                          */
        IUserService serviceProxy = (IUserService) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //开启事务
                        myAspect.before();

                        //方法返回值是业务方法的返回值
                        Object retObj = method.invoke(userService, args);
                        System.out.println("拦截返回值：" + retObj);

                        //提交事务
                        myAspect.after();

                        return retObj;
                    }
                }
        );
        return serviceProxy;
    }

    /**
     * cglib 生成代理实现 AOP 编程
     */
    public static StudentService createStudentService() {
        //1.创建目标对象 target
        final StudentService studentService = new StudentService();//内部类访问局部变量，变量要加final
        //2.声明切面类
        final MyAspect myAspect = new MyAspect();
        //3.创建增强对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(studentService.getClass());
        //设置回调【拦截】
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                /* proxy：class cn.yb.spring.service.StudentService$$EnhancerByCGLIB$$929778c7
                    proxy 代理对象是StudentService的子类*/
                System.out.println(proxy.getClass());
                //System.out.println(proxy);打印这个报错：java.lang.StackOverflowError
                System.out.println(methodProxy);
                //开启事务
                myAspect.before();
                //放行方法(两种)
                //Object retObj = method.invoke(studentService, args);
                Object retObj = methodProxy.invokeSuper(proxy, args);//解耦
                //提交事务
                myAspect.after();
                return retObj;
            }
        });
        //创建代理对象
        StudentService serviceProxy2 = (StudentService) enhancer.create();
        return serviceProxy2;
    }
}
