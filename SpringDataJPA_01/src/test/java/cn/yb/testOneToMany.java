package cn.yb;

import cn.yb.dao.CustomerDao;
import cn.yb.dao.LinkManDao;
import cn.yb.domain.Customer;
import cn.yb.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testOneToMany {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    /**
     * 保存一个客户，保存一个联系人
     * 问题：客户和联系人作为独立的数据保存到了数据库
     * 原因：实体类中没有配置关系
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToMany() {
        Customer customer = new Customer();
        customer.setCustName("Baidu");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("王五");

        /**
         * 如果没有下面这句就会出现上面的问题
         * 这句是配置客户到联系人的关系（一对多）
         *      从客户的角度看：发送两条insert语句插入数据，然后更新外键到数据库
         * 由于我们配置了客户到联系人的关系：客户可以对外键进行维护
         */
        customer.getLinkMens().add(linkMan);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToMany1() {
        Customer customer = new Customer();
        customer.setCustName("今日头条");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("张三");

        /**
         * 这句是配置联系人到客户的关系（多对一）
         *      从联系人的角度看：发送两条insert语句保存数据
         * 由于我们配置了联系人到客户的映射关系：联系人可以对外键进行维护
         */
        linkMan.setCustomer(customer);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**
     * 会有一条多余的update语句
     *      由于一的一方可以维护外键，会执行update语句
     *      解决：一的一方放弃外键维护权即可
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToMany2() {
        Customer customer = new Customer();
        customer.setCustName("今日头条");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("张三");

        customer.getLinkMens().add(linkMan);//配置了一对多关系（发送一条update更新外键）
        linkMan.setCustomer(customer);//配置了多对一关系，保存数据时已经给外键赋值了

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**
     * 级联操作
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeAdd() {
        Customer customer = new Customer();
        customer.setCustName("今日头条");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("张三");

        customer.getLinkMens().add(linkMan);
        linkMan.setCustomer(customer);

        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeRemove() {
        Customer one = customerDao.findOne(1L);
        customerDao.delete(one);
    }
}
