package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Customer;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class testHQL {

    /**
     * 投影查询
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();
        Query query = session.createQuery("select c.id,c.name from Customer c ");
        List<Object[]> list = query.list();

        for (Object[] objs : list) {
            for (Object obj : objs) {
                System.out.println(obj);
            }
        }
        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 排序：order by
     * desc：降序
     * asc：升序
     */
    @Test
    public void test2() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();
        Query query = session.createQuery("from Customer c order by c.id desc ");
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 聚合函数
     */
    @Test
    public void test3() {
        //1.创建session
        Session session = HibernateUtils.openSession();

        //count
        /*Query query = session.createQuery("select count(*) from Customer c");
        Long count = (Long) query.uniqueResult();
        System.out.println("客户表总记录数" + count);*/

        //平均数 avg
        Query query = session.createQuery("select avg(c.id) from Customer c");
        Double avg = (Double) query.uniqueResult();
        System.out.println("客户表总记录数" + avg);
        //4.关闭会话
        session.close();
    }

    /**
     * 分组：根据客户分组查询有多少条订单
     * select o.customer_id,count(o.customer_id) from t_order o group by o.customer_id
     */
    @Test
    public void test4() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("select o.customer,count (o.customer.id) from Order o group by o.customer");
        List<Object[]> list = query.list();
        for (Object[] o : list) {
            for (Object o1 : o) {
                System.out.println(o1);
            }
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 交叉连接：笛卡尔积
     */
    @Test
    public void test5() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        List<Object[]> list = session.createQuery("from Order,Customer ").list();
        for (Object[] o : list) {
            System.out.println(o[0] + ":" + o[1]);
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 隐式内连接[join]：等效sql隐式内连接
     * 相当于在笛卡尔积上面加了过滤条件
     */
    @Test
    public void test6() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        List<Object[]> list = session.createQuery("from Order o,Customer c where o.customer=c").list();
        for (Object[] o : list) {
            System.out.println(o[0] + ":" + o[1]);
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 内连接[inner join]
     * 返回的数据封装到了数组中
     * Object[] objs = {Customer,Order}
     * 左表如果没有右表的匹配数据，左表不显示
     */
    @Test
    public void test7() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        List<Object[]> list = session.createQuery("from Customer c inner join c.orders").list();
        for (Object[] o : list) {
            System.out.println(o[0] + ":" + o[1]);
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 迫切内连接[inner join fetch]
     * 返回的数据是List<Object>
     */
    @Test
    public void test8() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        List<Customer> list = session.createQuery("from Customer c inner join fetch c.orders").list();
        for (Customer o : list) {
            System.out.println(o.getName());
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 左外连接[left outer join]
     * 返回的数据封装到了数组中
     * Object[] objs = {Customer,Order}
     * 左表如果没有右表的匹配数据，左表记录也会显示
     */
    @Test
    public void test9() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        List<Object[]> list = session.createQuery("from Customer c left outer join c.orders").list();
        for (Object[] o : list) {
            System.out.println(o[0] + ":" + o[1]);
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 迫切左外连接
     */
    @Test
    public void test10() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        List<Customer> list = session.createQuery("from Customer c left outer join fetch c.orders").list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 右外连接[right outer join]
     * 返回的数据封装到了数组中
     * Object[] objs = {Customer,Order}
     * 右表如果没有左表的匹配数据，右表记录也会显示
     */
    @Test
    public void test11() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        List<Object[]> list = session.createQuery("from Customer c right outer join c.orders").list();
        for (Object[] o : list) {
            System.out.println(o[0] + ":" + o[1]);
        }
        //4.关闭会话
        session.close();
    }

    /**
     * 命名查询，将HQL写在xml文件中
     * 1.写在类class标签中【局部的】
     * 2.写在hibernate-mapping标签中【全局的】
     */
    @Test
    public void test12() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        /**
         * 获取xml中局部(class中)的hql
         * 要加包名加类名
         */
        Query query1 = session.getNamedQuery("cn.yb.hibernate.domain.Customer.hql1");
        System.out.println(query1.list());
        /**
         * 获取xml中全局(hibernate-mapping中)的hql
         * 不需要要加包名加类名
         */
        Query query2 = session.getNamedQuery("hql2");
        query2.setParameter(0, "姚斌");
        System.out.println(query2.uniqueResult());
        //4.关闭会话
        session.close();
    }
}

