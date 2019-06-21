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

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testQuery {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    /**
     * could not initialize proxy - no Session(报错是因为没配置事务)
     * 对象导航查询（查询一个对象的时候，通过此对象查询所有关联对象）
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void test1() {
        Customer customer = customerDao.getOne(1L);
        //对象导航查询此客户下的所有联系人
        Set<LinkMan> linkMens = customer.getLinkMens();
        for (LinkMan linkMen : linkMens) {
            System.out.println(linkMen);
        }
    }

    /**
     * 从一查多
     * 对象导航查询默认使用懒加载形式
     * 修改配置，将延迟加载改为立即加载：fetch，配置到多表映射关系上
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void test2() {
        Customer customer = customerDao.findOne(1L);
        //对象导航查询此客户下的所有联系人
        Set<LinkMan> linkMens = customer.getLinkMens();
        System.out.println(linkMens.size());
    }

    /**
     * 从多查一
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void test3() {
        LinkMan linkMan = linkManDao.findOne(2L);
        //对象导航查询此客户下的所有联系人
        Customer customer = linkMan.getCustomer();
        System.out.println(customer);
    }
}
