package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Customer;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

public class testLock {

    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        /**
         * 演示查找客户表：A线程【命令行】开启事务，读取一行数据加锁
         * B线程【应用程序】，开启事务，读取一行数据加锁
         */
        //执行查询SQL语句加写锁
        /*Customer customer = (Customer) session.get(Customer.class, 1, LockOptions.UPGRADE);
        System.out.println(customer);*/

        /**
         * HQL中不能直接写 for update
         * 第二种方式：query.setLockOptions(LockOptions.UPGRADE);
         */
        Query query = session.createQuery("from Customer where id = ?");
        query.setLockOptions(LockOptions.UPGRADE);
        query.setParameter(0, 1);
        Customer customer1 = (Customer) query.uniqueResult();
        System.out.println(customer1);

        session.getTransaction().commit();
        session.close();
    }


    /**
     * hibernate写锁/排他锁的实现
     */
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        /**
         * 演示查找客户表：A线程【命令行】开启事务，读取一行数据加锁
         * B线程【应用程序】，开启事务，更新一行数据
         * 更新时不用写：query.setLockOptions(LockOptions.UPGRADE)
         */
        Query query = session.createQuery("update Customer set name =? where id = ?");
        query.setParameter(0, "yb");
        query.setParameter(1, 1);

        //执行HQL
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        /**
         * 乐观锁：每次更新版本加1
         * 如果当前版本【2】比数据库版本【3】低，就不会更新，会出错
         * 乐观锁时hibernate自己实现的
         * 悲观锁for update是mysql内部实现的
         */
        Customer customer = (Customer) session.get(Customer.class,1);
        customer.setName("yaobin");

        session.getTransaction().commit();
        session.close();

    }

}
