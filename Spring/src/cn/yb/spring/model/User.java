package cn.yb.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PreDestroy;

public class User implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private Integer id;
    private String username;
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User() {
        System.out.println("1.User_实例化！");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        System.out.println("2.User_给属性赋值username:" + username + ",password:" + password);
        this.username = username;
    }

    public void setPassword(String password) {
        System.out.println("2.User_给属性赋值username:" + username + ",password:" + password);
        this.password = password;
    }

    @Override
    public void setBeanName(String s) {
        //bean标签里面的 id 属性值
        System.out.println("3.User_设置bean的名字:" + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //将对象放入bean工厂（容器）
        System.out.println("4.User_设置bean工厂:" + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6.User_属性赋值完成");
    }

    @Override
    public void destroy() throws Exception {
        //资源释放
        System.out.println("9.User_bean对象被销毁");
    }

    //@PostConstruct注解相当于 bean 标签中配置了 init-method 方法为该方法
    public void myInit() {
        System.out.println("7.User_自定义的初始化方法");
    }

    //@PreDestroy注解相当于 bean 标签中配置了 destroy-method 方法为该方法
    public void myDestroy() {
        //资源释放
        System.out.println("10.User_自定义的销毁方法");
    }
}
