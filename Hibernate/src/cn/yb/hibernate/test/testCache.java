package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Company;
import cn.yb.hibernate.domain.Customer;
import cn.yb.hibernate.domain.User;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class testCache {

    /**
     * 一级缓存：session级别
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();

        //获取数据，通过get方法可以获取一个持久态对象
        User user1 = (User) session.get(User.class, 2);
        System.out.println(user1);

        //因为session中有数据，所以不用查询数据库，只有一条查询语句
        User user2 = (User) session.get(User.class, 2);
        System.out.println(user2);//user1和user2地址一样，因为同一session中的同一个对象

        //4.关闭会话
        session.close();
    }

    /**
     * 清除指定对象缓存
     */
    @Test
    public void test() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //获取数据，通过get方法可以获取一个持久态对象
        User user1 = (User) session.get(User.class, 2);
        System.out.println(user1);
        //清除指定对象缓存
        session.evict(user1);
        //session没有数据，查询数据库，两条select语句
        User user2 = (User) session.get(User.class, 2);
        System.out.println(user2);//user1和user2地址不一样
        //4.关闭会话
        session.close();
    }

    /**
     * 快照，相当于session的备份
     */
    @Test
    public void test2() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        //获取数据，通过get方法可以获取一个持久态对象
        User user = (User) session.get(User.class, 2);
        user.setUsername("zhangsan");
        session.getTransaction().commit();
        /**
         * 修改数据后，一级缓存数据与快照数据不一致，执行update
         * 再次提交后不执行update语句，因为一级缓存数据与快照数据一致
         */
        //4.关闭会话
        session.close();
    }

    /**
     * 一级缓存的刷新
     */
    @Test
    public void test3() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        //获取数据，通过get方法可以获取一个持久态对象
        User user = (User) session.get(User.class, 2);
        user.setUsername("zhangsan");
        //强制刷新，让一级缓存数据与数据库一致
        session.flush();
        user.setUsername("王五");
        session.getTransaction().commit();
        /**
         * 本来应只有一条update语句，但是flush后，会有两条update语句
         */
        //4.关闭会话
        session.close();
    }

    /**
     * HQL和Criteria的结果会进行一级缓存
     */
    @Test
    public void test4() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("from User ");
        List<User> list = query.list();
        /**
         * HQL查询结果会存入session
         * 再次查询从session中取，总共只有一条select语句
         */
        User user = (User) session.get(User.class, 2);
        System.out.println(user);
        //4.关闭会话
        session.close();
    }

    /**
     * SQL的结果不会添加到一级缓存
     */
    @Test
    public void test5() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
        List<User> list1 = sqlQuery.list();
        /**
         * SQL查询结果不会存入session
         * 再次查询会直接查询数据库，总共有两条select语句
         */
        User user2 = (User) session.get(User.class, 2);
        System.out.println(user2);
        session.close();
    }

    /**
     * 1.persist保存的对象，在保存前，不能设置id,否则会报错
     * 2.save和 persist都可以持久化对象
     * 3.save 因为需要返回一个主键值，因此会立即执行 insert 语句
     * 而 persist 在事务外部调用时则不会立即执行 insert 语句
     * 在事务内调用还是会立即执行 insert 语句的。
     */
    @Test
    public void test6() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();

        User user = new User("yb2", "564924");
        //user.setUid(15);
        session.persist(user);

        //session.getTransaction().commit();
        session.close();
    }


    @Test
    public void test7() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();

        //读取数据后，会把Company存在session中
        Company company = (Company) session.get(Company.class, 1);
        System.out.println(company.getName());
        //再次读取不会再执行select语句
        //清除session缓存后，再次查询需要查询数据库
        session.clear();

        Company company1 = (Company) session.get(Company.class, 1);
        System.out.println(company1.getName());

        //session.getTransaction().commit();
        session.close();
    }

    /**
     * 二级缓存测试
     * 类缓存
     */
    @Test
    public void test8() {
        //1.创建session
        Session session1 = HibernateUtils.openSession();
        Session session2 = HibernateUtils.openSession();
        //获取数据，默认放在一级缓存session缓存
        Customer customer = (Customer) session1.get(Customer.class, 1);
        System.out.println(customer);
        //清除缓存
        session1.clear();
        //在配置文件中配置了二级类缓存，session中清除后，会去类缓存中读取数据，所以只有一条select语句
        Customer customer2 = (Customer) session1.get(Customer.class, 1);
        System.out.println(customer2);
        //另一个session获取数据
        //在配置文件中配置了二级类缓存，session是同一个sessionFactory生产的，所以只有一条select语句
        Customer customer3 = (Customer) session2.get(Customer.class, 1);
        System.out.println(customer3);
        session1.close();
        session2.close();
    }

    /**
     * 二级缓存测试
     * 集合缓存
     */
    @Test
    public void test9() {
        //1.创建session
        Session session1 = HibernateUtils.openSession();
        Session session2 = HibernateUtils.openSession();
        //获取数据，默认放在一级缓存session缓存
        Customer customer = (Customer) session1.get(Customer.class, 1);
        System.out.println(customer.getOrders());
        session1.clear();
        Customer customer2 = (Customer) session1.get(Customer.class, 1);
        System.out.println(customer2.getOrders());
        session1.close();
        session2.close();
    }

    /**
     * 查询缓存：针对HQL，HQL相同不再查询
     */
    @Test
    public void test10() {
        //1.创建session
        Session session1 = HibernateUtils.openSession();
        Session session2 = HibernateUtils.openSession();
        Query query1 = session1.createQuery("from Customer ");
        query1.setCacheable(true);//设置允许缓存
        System.out.println(query1.list());

        Query query2 = session2.createQuery("from Customer ");

        query2.setCacheable(true);//设置允许缓存
        System.out.println(query2.list());
        session1.close();
        session2.close();
    }

    /**
     * 时间戳缓存：两次连续执行的操作相同时，不在查询数据库
     */
    @Test
    public void test11() {
        //1.创建session
        Session session1 = HibernateUtils.openSession();
        session1.getTransaction().begin();

        Customer customer = (Customer) session1.get(Customer.class, 1);
        System.out.println(customer);

        session1.getTransaction().commit();
        session1.close();


        //另一个session获取数据
        Session session2 = HibernateUtils.openSession();
        Customer customer2 = (Customer) session2.get(Customer.class, 1);
        System.out.println(customer2);

        session2.close();
    }
}
