package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class testSessionAPI {

    @Test
    public void test1() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();
        /**
         * Session的get和load方法（都是查询数据）
         * get:没有数据返回 null
         * load：没有数据则报错
         */
        //get获取数据
        User user1 = (User) session.get(User.class, 2);
        User user2 = (User) session.load(User.class, 2);
        System.out.println(user1);
        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }

    /**
     * session的delete删除数据的两种方式
     * 1.获取要删除的对象，再调用delete方法
     * 注意：这种方式需要手动事务操作
     */
    @Test
    public void test2() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();
        //第一种：获取要删除的对象，再调用delete方法
        //开启事务
        session.getTransaction().begin();
        //get获取数据
        User user = (User) session.get(User.class, 2);
        //删除数据
        session.delete(user);
        //提交事务
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }

    /**
     * session的delete删除数据的两种方式
     * 2.创建模型，设置id，调用delete方法
     * 这种方式不用查询数据库，是直接根据id删除数据
     */
    @Test
    public void test3() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();
        //第一种：获取要删除的对象，再调用delete方法
        //开启事务
        session.getTransaction().begin();
        //创建模型，设置id
        User user = new User();
        user.setUid(1);
        //删除数据
        session.delete(user);
        //提交事务
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }

    /**
     * session的update方法
     * 1.通过get获取数据，调用模型set方法给模型属性赋值，事务提交自动执行update语句
     * 2.自己封装User对象，设置id，需要调用update方法
     */
    @Test
    public void test4() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();
        //第一种：获取对象，调用update方法
        //开启事务
        session.getTransaction().begin();
        //get获取数据
        User user = (User) session.get(User.class, 3);
        //设置数据
        user.setPassword("54321");
        //更新数据
        session.update(user);//有id时才会更新
        /**
         * session.saveOrUpdate(user);
         * 判断user有没有id，没有就插入数据，有就更新数据
         */
        //session.saveOrUpdate(user);
        //提交事务
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }
}
