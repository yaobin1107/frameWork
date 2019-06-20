package cn.yb.test;

import cn.yb.jpa.domain.Customer;
import cn.yb.jpa.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * jpql查询步骤：
 * 1.定义jpql
 * 2.根据jpql创建query对象 entityManager.createQuery(jpql)
 * 3.对参数赋值
 * 4.查询，得到结果集
 */
public class JPQLTest {

    /**
     * 查询全部
     * sql：select * from cst_customer
     * jpql:from cn.yb.jpa.domain.Customer
     */
    @Test
    public void testFindAll() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //查询全部
        String jpql = "from cn.yb.jpa.domain.Customer";//可以简写 from Customer
        Query query = entityManager.createQuery(jpql);
        //发送查询，封装结果集
        List list = query.getResultList();
        //遍历
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }

    /**
     * 排序查询：倒序查询所有客户（根据id倒序）
     * sql：select * from cst_customer order by cust_id desc
     * jpql：from Customer order by custId desc
     */
    @Test
    public void testOrderBy() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //查询全部
        String jpql = "from Customer order by custId desc";//可以简写 from Customer
        Query query = entityManager.createQuery(jpql);
        //发送查询，封装结果集
        List list = query.getResultList();
        //遍历
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }

    /**
     * 统计客户总数
     * sql：select count(cust_id) from cst_customer
     * jpql：select count(custId) from Customer
     */
    @Test
    public void testCount() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //查询全部
        String jpql = "select count(custId) from Customer";//可以简写 from Customer
        Query query = entityManager.createQuery(jpql);
        //发送查询，封装结果集
        Object result = query.getSingleResult();
        System.out.println(result);

        transaction.commit();
        entityManager.close();
    }

    /**
     * 分页查询
     * sql：select * from cst_customer limit ?,?
     * jpql：from Customer
     */
    @Test
    public void testLimit() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //查询全部
        String jpql = "from Customer";//可以简写 from Customer
        Query query = entityManager.createQuery(jpql);
        //对参数赋值（分页参数）
        query.setFirstResult(0);//起始索引
        query.setMaxResults(2);//每次查询的条数
        //发送查询，封装结果集
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }

    /**
     * 条件查询
     * sql：select * from cst_customer where cust_name like ?
     * jpql：from Customer where custName like ?
     */
    @Test
    public void testCondition() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //查询全部
        String jpql = "from Customer where custName like ?";//可以简写 from Customer
        Query query = entityManager.createQuery(jpql);
        //对参数赋值（分页参数）
        query.setParameter(1, "%姚%");
        //发送查询，封装结果集
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }
}
