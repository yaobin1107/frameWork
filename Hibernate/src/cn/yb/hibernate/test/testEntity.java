package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

public class testEntity {

    /**
     * 实体类entity（model）的编写规则：
     * 1.必须提供无参构造方法，获取数据封装模型会调用无参构造方法
     * 2.提供一个标识属性，映射数据表主键字段，提供id
     * 3.所有属性提供public访问控制符的set/get方法(javaBean)
     * 4.标识属性应尽量使用基本数据类型的包装类型
     * 5.不要用final修饰实体（将无法生成代理对象进行优化）
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //获取数据
        User user = (User) session.get(User.class, 10);
        System.out.println(user);
        //4.关闭会话
        session.close();
    }

    @Test
    public void test2() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        //获取数据
        User user = new User("yb", "564924");
        user.setBirthday(new Date());
        session.save(user);
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }
}
