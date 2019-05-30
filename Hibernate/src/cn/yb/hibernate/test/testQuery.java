package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.List;

public class testQuery {

    /**
     * query的使用
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
        //sql:select * from t_user where username = 'yb' and password = '123';
        //hql面向对象的查询语言
        Query query = session.createQuery("from User where username=? and password=?");
        query.setParameter(0, "yb2");
        query.setParameter(1, "123456");
        //执行查询
        User user = (User) query.uniqueResult();//只查询一条结果
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
        Query query = session.createQuery("from User");
        /**
         * 分页查询
         * setFirstResult：设置起始位置
         * setMaxResults：返回的数据条数
         */
        query.setFirstResult(0);
        query.setMaxResults(3);
        //执行查询，返回多行数据
        List userList = query.list();
        for (Object obj : userList) {
            System.out.println(obj);
        }
        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }
}
