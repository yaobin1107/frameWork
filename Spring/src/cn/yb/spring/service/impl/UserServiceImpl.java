package cn.yb.spring.service.impl;

import cn.yb.spring.dao.IUserDao;
import cn.yb.spring.model.User;
import cn.yb.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 在类上声明了 @Service ，表示 Service 层
 * 并且相当于在 xml 中配置了 bean
 * <p>
 * 在类上声明了 @Service("myService")
 * 对应在 Action 类中会有一个属性上面声明了 @@Autowired 和 @Qualifier("myUserService")
 * 或者直接声明 @Resource(name = "myUserService") //相当于上面两行注解
 * <p>
 * 在类上声明了 @Scope("prototype") ,表示该类的对象是多例的
 * 不写的话，默认是单例
 */

//@Service("myService")
//@Scope("prototype")
@Service("userService")
public class UserServiceImpl implements IUserService {

    private String name;

    /**
     * 在属性上声明 @Autowired
     * 表示 Spring 会自动往该属性（userDao）赋值（就不需要 get/set 方法了）
     */
    @Autowired
    private IUserDao userDao;

    public UserServiceImpl() {
        System.out.println(" UserServiceImpl 的空参构造方法！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("添加用户！" + name);
    }

    @Override
    public void add(User user) {
        System.out.println("Service_添加用户！" + user);
        //调用Dao
        userDao.add(user);
    }

    @Override
    public void addUser() {
        System.out.println("添加用户_addUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户_deleteUser");
        //int i = 10/0;测试异常通知
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户_updateUser");
    }

    @Override
    public int deleteUser(int id) {
        System.out.println("通过id删除用户_deleteUser(int id)");
        //int i = 10/0;
        return id;
    }
}
