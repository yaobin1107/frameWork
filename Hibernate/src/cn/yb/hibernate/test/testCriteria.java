package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class testCriteria {

    /**
     * Criteria 查询对象
     */
    @Test
    public void test1() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();

        //查询对象
        Criteria criteria = session.createCriteria(User.class);
        /**
         * eq：等于
         * gt：大于(greatThan)
         * ge：大于等于
         * lt：小于(lessThan)
         * le：小于等于
         */
        criteria.add(Restrictions.eq("username", "yb5"));
        criteria.add(Restrictions.eq("password", "35275"));
        User user = (User) criteria.uniqueResult();
        System.out.println(user);

        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }


    @Test
    public void test2() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();

        //查询对象
        Criteria criteria = session.createCriteria(User.class);
        /**
         * eq：等于
         * gt：大于(greatThan)
         * ge：大于等于
         * lt：小于(lessThan)
         * le：小于等于
         */
        //查询条件
        criteria.add(Restrictions.gt("uid", 8));
        List userList = criteria.list();
        System.out.println(userList);

        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }

    /**
     * 模糊查询
     */
    @Test
    public void test3() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();

        //查询对象
        Criteria criteria = session.createCriteria(User.class);
        //查询条件
        criteria.add(Restrictions.like("username", "%5%"));
        User user = (User) criteria.uniqueResult();
        System.out.println(user);

        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }
}
