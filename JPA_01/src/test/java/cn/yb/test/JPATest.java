package cn.yb.test;

import cn.yb.jpa.domain.Customer;
import cn.yb.jpa.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPATest {
    /**
     * 测试JPA的保存：保存一个客户到数据库
     * JPA操作步骤：
     * 1.加载配置文件创建工厂(实体管理器工厂)对象
     * 2.通过工厂获取实体管理器
     * 3.获取事务对象，开启事务
     * 4.完成增删改查操作
     * 5.提交事务(回滚事务)
     * 6.释放资源
     */
    @Test
    public void test1() {
        //1.加载配置文件创建工厂(实体管理器工厂)对象
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过工厂获取实体管理器
        EntityManager entityManager = factory.createEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //4.完成增删改查操作：保存一个客户到数据库
        Customer customer = new Customer();
        customer.setCustName("姚斌");
        customer.setCustIndustry("学生");
        //保存操作
        entityManager.persist(customer);
        //5.提交事务(回滚事务)
        transaction.commit();
        //6.释放资源
        entityManager.close();
        factory.close();

    }

    @Test
    public void test2() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setCustName("姚斌2");
        customer.setCustIndustry("学生2");

        entityManager.persist(customer);

        transaction.commit();

        entityManager.close();
    }

    /**
     * 根据id查询客户
     * find:
     * 1.获取的查询对象就是当前客户对象本身
     * 2.在调用find方法时，，会立即发送sql语句查询数据库
     */
    @Test
    public void testFind() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /**
         * find(Class<T> aClass,Object o)
         *      class：查询出来的结果要封装成的对象，字节码！
         *      o：可以是主键id
         */
        Customer customer = entityManager.find(Customer.class, 2l);
        System.out.println(customer);

        transaction.commit();
        entityManager.close();
    }

    /**
     * getReference:
     * 1.获取的对象是一个动态代理对象
     * 2.在调用getReference方法时，不会立即发送sql语句查询数据库
     * 当调用查询结果对象时，才执行sql查询数据库（懒加载）
     */
    @Test
    public void testGetReference() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /**
         * getReference(Class<T> aClass,Object o)
         *      class：查询出来的结果要封装成的对象，字节码！
         *      o：可以是主键id
         */
        Customer customer = entityManager.getReference(Customer.class, 2l);
        System.out.println(customer);

        transaction.commit();
        entityManager.close();
    }

    /**
     * 删除用户
     */
    @Test
    public void testRemove() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //根据id查询用户
        Customer customer = entityManager.getReference(Customer.class, 2l);
        //将查询到的用户删除
        entityManager.remove(customer);

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testUpdate() {
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //根据id查询用户
        Customer customer = entityManager.find(Customer.class, 1l);
        //更新查询到的用户
        customer.setCustIndustry("IT");
        entityManager.merge(customer);

        transaction.commit();
        entityManager.close();
    }
}
