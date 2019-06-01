package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Customer;
import cn.yb.hibernate.domain.Order;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class testQBC {

    /**
     * QBC查询，query by criteria
     * 排序：也叫Order对象
     * order by：排序
     * Order：订单
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();
        Criteria criteria = session.createCriteria(Order.class);
        //添加排序
        criteria.addOrder(org.hibernate.criterion.Order.desc("id"));
        List<Order> list = criteria.list();
        for (Order order : list) {
            System.out.println(order);
        }
        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 离线查询对象：DetachedCriteria
     */
    @Test
    public void test2() {

        //1.web：servlet，action
        //2.service====================findCustomerByName（String name）======================
        //创建离线查询对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        //拼接条件
        detachedCriteria.add(Restrictions.eq("name", "姚斌"));

        //3.dao====================findCustomerByName（DetachedCriteria detachedCriteria）======================
        //1.创建session
        Session session = HibernateUtils.openSession();
        //获取一个可以执行的查询对象
        Criteria executableCriteria = detachedCriteria.getExecutableCriteria(session);
        //执行查询
        System.out.println(executableCriteria.uniqueResult());

        //session.getTransaction().begin();
        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }
}
