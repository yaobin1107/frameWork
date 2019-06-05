package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Customer;
import cn.yb.hibernate.domain.Order;
import cn.yb.hibernate.domain.User;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class testRelationship {

    /**
     * 保存多对一，一对多数据
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        //创建客户
        Customer customer = new Customer();
        customer.setName("姚斌7");
        //创建订单
        Order order1 = new Order();
        order1.setName("电脑");
        Order order2 = new Order();
        order2.setName("手机");
        //维护客户与订单的关系
        order1.setCustomer(customer);
        order2.setCustomer(customer);
        //客户拥有订单(订单与客户的关系)
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        //保存数据
        session.save(customer);
        session.save(order1);
        session.save(order2);
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 查询一对多
     */
    @Test
    public void test2() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //查询一对多
        Customer customer = (Customer) session.get(Customer.class, 3);
        System.out.println("客户的名字：" + customer.getName());
        /**
         * 获取客户的所有订单
         * 默认情况下，只有当使用Customer的orders数据时才会执行SQL
         */
        Set<Order> orders = customer.getOrders();
        for (Order order : orders) {
            System.out.println("订单名称：" + order.getName());
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 一对多的删除
     */
    @Test
    public void test3() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = (Customer) session.get(Customer.class, 3);
        /**
         * 删除一对多:
         * 如果要删除一对多，至少要把order的约束去掉（外键关系）
         */
        for (Order order : customer.getOrders()) {
            //删除外键关系
            order.setCustomer(null);
        }
        session.delete(customer);//没有外键关系后即可删除
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * cascade:级联
     * save-update：级联保存，保存A(客户)时，同时保存B(订单)
     */
    @Test
    public void test4() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();


        //创建客户
        Customer customer = new Customer();
        customer.setName("姚斌7");
        //创建订单
        Order order1 = new Order();
        order1.setName("电脑");
        Order order2 = new Order();
        order2.setName("手机");
        //维护客户与订单的关系
        order1.setCustomer(customer);
        order2.setCustomer(customer);
        //客户拥有订单(订单与客户的关系)
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        /**
         * 保存数据
         * 不用再手动保存订单，hibernate级联保存，自动保存了订单
         */
        session.save(customer);


        session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 级联删除
     */
    @Test
    public void test5() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        Customer customer = (Customer) session.get(Customer.class, 6);
        /**
         * 级联删除：不用处理外键关系
         *      删除A的同时，会删除B：内部实现为，将外键设置为空，再删除
         */
        session.delete(customer);//没有外键关系后即可删除

        session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 级联孤儿删除
     */
    @Test
    public void test6() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        Customer customer = (Customer) session.get(Customer.class, 9);
        /**
         * 级联孤儿删除：把客户的所有订单移除
         * 不能用下面两种方法移除订单,因为客户还不知道自己的订单
         * customer.setOrder(null);
         * customer.setOrder(new HashSet<Order>());
         */
        //把订单从Customer的Set集合删除
        Set<Order> orders = customer.getOrders();
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            iterator.next();//取到下一个元素
            iterator.remove();//移除取到的元素
        }
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }
}
