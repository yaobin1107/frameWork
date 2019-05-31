package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Order;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
    public void test11() {
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
}
