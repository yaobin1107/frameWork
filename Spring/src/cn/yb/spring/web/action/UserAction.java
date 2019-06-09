package cn.yb.spring.web.action;

import cn.yb.spring.model.User;
import cn.yb.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 在类上声明了 @Controller ，相当于在 xml 中配置了 bean
 * 并且表示这是 web 层
 * <p>
 * 在类上声明了 @Scope("prototype") ,表示该类的对象是多例的
 * 不写的话，默认是单例
 */
@Controller
//@Scope("prototype")//默认是单例，配置后为多例
public class UserAction {

    /**
     * 在属性上声明 @Autowired
     * 表示 Spring 会自动往该属性（userService）赋值（就不需要 get/set 方法了）
     * <p>
     * Autowired 是根据类型注入值
     * 如果是一个接口，它会从容器中找接口的实现类
     * 如果是一个类，就直接找类
     * <p>
     * 在属性上声明 @Qualifier("myUserService") 表示根据指定 id （myUserService）注入入属性
     * 他会找一个类上声明了 @Service("myUserService") 的 Service 实现类为该属性赋值
     * <p>
     * 在属性上声明 @Resource(name = "myUserService")
     * 相当于同时在属性上声明了 @Autowired 和 @Qualifier("myUserService")
     */

    /*
     * @Autowired
     * @Qualifier("myUserService")
     *
     * @Resource(name = "myUserService") //相当于上面两行注解
     */

    @Autowired
    private IUserService userService;


    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void save(User user) {
        System.out.println("Action_save方法");
        userService.add(user);
    }
}
