package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Course;
import cn.yb.hibernate.domain.Customer;
import cn.yb.hibernate.domain.Order;
import cn.yb.hibernate.domain.Student;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class testLoad {

    /**
     * 类级别加载策略
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();
        /**
         * get方法即时加载数据，执行SQL
         * load方法懒加载，用到数据时才执行SQL，load如果只是取id也不会执行SQL【没必要】
         * 如果在Student.hbm.xml的class中配置了 lazy=“false” 这是load方法是即时加载
         */
        Student student = (Student) session.load(Student.class, 2);
        System.out.println("=======================================");
        System.out.println("学生姓名：" + student.getName());

        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 关联别加载策略
     */
    @Test
    public void test2() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();

        Student student = (Student) session.get(Student.class, 2);
        /**
         * 1.默认情况下Student下的Course数据，只有访问的时候，才执行SQL
         * 2.在set中配置lazy=“false”，不用访问course属性，也会先执行SQL查询数据
         */
        Set<Course> courses = student.getCourses();
        System.out.println("=======================================");
        System.out.println(courses);

        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * set集合中fecth属性
     * 1.select：默认，执行两条SQL
     * 2.join：查询数据使用一条SQL语句搞定，使用左外连接
     * 3.subselect：子查询，在条件里面有select语句
     * 子查询只能用于多对多，一对多中
     */
    @Test
    public void test3() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();

        Student student = (Student) session.get(Student.class, 2);
        System.out.println(student.getCourses());

        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * subselect：子查询，在条件里面有select语句
     * 子查询只能用于多对多，一对多中
     */
    @Test
    public void test4() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();

        Query query = session.createQuery("from Student ");
        List<Student> list = query.list();
        for (Student student : list) {
            System.out.println("学生姓名：" + student.getName());
            System.out.println("学生课程：" + student.getCourses());
        }

        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 多对一加载策略
     */
    @Test
    public void test5() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();

        //查订单【默认懒加载】
        Order order = (Order) session.load(Order.class, 7);
        System.out.println("=================================");
        System.out.println("订单名称：" + order.getName());
        //看订单所属的客户【默认懒加载】
        System.out.println("=================================");
        Customer customer = order.getCustomer();
        System.out.println("订单所属客户：" + customer.getName());

        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }

    /**
     * 批量加载
     */
    @Test
    public void test6() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        //session.getTransaction().begin();

        Query query = session.createQuery("from Customer ");
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println("客户名称：" + customer.getName() + "--" + "订单数量：" + customer.getOrders().size());
        }

        //session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }
}
