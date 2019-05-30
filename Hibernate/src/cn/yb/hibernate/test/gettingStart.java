package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class gettingStart {

    @Test
    public void test1() {

        /**
         * 添加表的映射文件的三种方法：
         * 1.在hibernate.cfg.xml中配置：<mapping resource="cn/yb/hibernate/domain/User.hbm.xml"/>
         * 2.new Configuration().configure().addResource("cn/yb/hibernate/domain/User.hbm.xml");
         * 3.new Configuration().configure().addClass(User.class);
         */
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //添加表的映射文件两只代码方式
        //1.cfg.addResource("cn/yb/hibernate/domain/User.hbm.xml");
        //2.cfg.addClass(User.class);
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        /**
         * sessionFactory创建session的两种方法
         * sessionFactory.openSession() 获取一个全新的session,这种方式要手动关闭session
         * sessionFactory.getCurrentSession() 获取一个与当前线程绑定的session，事务提交或者回滚时会自动关闭session
         */
        //3.创建会话
        Session session = factory.openSession();
        //开启事务
        Transaction transaction = session.getTransaction();
        transaction.begin();
        //保存[直接把对象保存到数据库]
        User user = new User();
        user.setUsername("yb");
        user.setPassword("123456");
        session.save(user);
        //提交事务
        transaction.commit();
        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }
}
