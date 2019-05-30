package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

public class testStatus {

    /**
     * 瞬时状态-->持久状态
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //获取数据
        /**
         * 瞬时状态：对象没有id，数据库没有记录，session中没有缓存
         */
        User user = new User("yb", "264681");
        System.out.println(user);

        session.save(user);
        System.out.println(user);
        /**
         * 经过保存后：有id，数据库有记录，session有缓存
         * 这样就是持久状态
         */
        System.out.println(user);
        //4.关闭会话
        session.close();
    }

    /**
     * 持久状态-->托管状态
     */
    @Test
    public void test2() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //获取数据，通过get方法可以获取一个持久态对象
        User user1 = (User) session.get(User.class, 2);
        System.out.println(user1);

        //清除session
        session.clear();
        /**
         * 清除session后：有id，数据库有记录，session没有缓存
         * 这样就是托管状态
         * session.close();
         * session.clear();
         * session.evict(Object o);清除指定对象的session缓存
         */
        User user2 = (User) session.get(User.class, 2);//因为session没数据，所以要重新查询数据库
        System.out.println(user2);

        //4.关闭会话
        session.close();
    }
}
