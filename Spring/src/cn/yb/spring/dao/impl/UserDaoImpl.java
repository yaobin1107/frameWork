package cn.yb.spring.dao.impl;

import cn.yb.spring.dao.IUserDao;
import cn.yb.spring.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 在类上 @Repository 相当于给 Dao 配置了 bean
 * 并且表示这是 Dao 层
 * <p>
 * 在类上声明了 @Scope("prototype") ,表示该类的对象是多例的
 * 不写的话，默认是单例
 */

//@Scope("prototype")
@Repository
public class UserDaoImpl implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(User user) {
        System.out.println("Dao_添加用户" + user);
        jdbcTemplate.update("insert into t_user (username,password) values (?,?)",
                user.getUsername(), user.getPassword());
    }


    /*========================bean生命周期============================*/
    //@PostConstruct注解相当于 bean 标签中配置了 init-method 方法为该方法
    @PostConstruct
    public void myInit() {
        System.out.println("自定义的初始化方法");
    }

    //@PreDestroy注解相当于 bean 标签中配置了 destroy-method 方法为该方法
    @PreDestroy
    public void myDestroy() {
        //资源释放
        System.out.println("自定义的销毁方法");
    }
}
