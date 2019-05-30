package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class testTransaction {

    @Test
    public void test1() {

        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();

        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();

        //3.创建会话
        Session session = factory.openSession();

        //开启事务
        Transaction transaction = session.getTransaction();
        transaction.begin();

        User user = new User();
        user.setUsername("yb4");
        user.setPassword("123456");
        //保存对象
        session.save(user);

        //提交事务
        transaction.commit();
        /**
         * transaction.rollback();回滚事务，一般写在catch中
         */
        //4.关闭会话
        session.close();

        //5.关闭工厂，释放资源
        factory.close();
    }
}
