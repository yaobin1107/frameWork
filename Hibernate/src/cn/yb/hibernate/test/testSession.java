package cn.yb.hibernate.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class testSession {

    @Test
    public void test1() {

        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();

        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();

        Session session1 = factory.openSession();
        Session session2 = factory.openSession();
        System.out.println(session1.hashCode());
        System.out.println(session2.hashCode());

        Session session3 = factory.getCurrentSession();
        Session session4 = factory.getCurrentSession();
        System.out.println(session3.hashCode());
        System.out.println(session4.hashCode());

        new Thread() {
            @Override
            public void run() {
                Session session5 = factory.getCurrentSession();
                Session session6 = factory.getCurrentSession();
                System.out.println(session5.hashCode());
                System.out.println(session6.hashCode());
            }
        }.start();
    }
}
