package cn.yb;

import cn.yb.dao.CustomerDao;
import cn.yb.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//声明Spring提供的测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定Spring容器配置文件
public class testDao {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(1L);
        System.out.println(customer);
    }

    /**
     * 保存或者更新
     * 根据传递对象是否存在主键id，如果没有id属性：保存
     * 如果存在id主键属性：查询并更新
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustName("张三");
        customer.setCustLevel("vip");
        customer.setCustAddress("北京");
        //customerDao.save(customer);
        Customer customer1 = new Customer();
        customer1.setCustId(4L);
        customer1.setCustName("张三");
        customer1.setCustLevel("vip");
        customer1.setCustAddress("北京");
        customerDao.save(customer1);

    }

    /**
     * 删除数据：先查再删
     */
    @Test
    public void testDelete() {
        customerDao.delete(4L);
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }

    /**
     * 统计查询：查询客户总数
     */
    @Test
    public void testCount() {
        long count = customerDao.count();
        System.out.println(count);
    }

    /**
     * 判断是否存在
     * sql：查询结果封装成对象，对象不为空则存在
     * 查询结果条数，大于零则存在
     */
    @Test
    public void testExists() {
        System.out.println(customerDao.exists(4L));
    }

    /**
     * 根据id查询
     * @Transactional：保证getOne正常运行
     * findOne：entityManager.find() 立即加载
     * getOne：entityManager.getReference() 返回的是代理对象，懒加载
     */
    @Test
    @Transactional
    public void testGetOne() {
        Customer one = customerDao.getOne(5L);
        System.out.println(one);
    }
}
