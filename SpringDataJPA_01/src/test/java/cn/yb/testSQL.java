package cn.yb;

import cn.yb.dao.CustomerDao;
import cn.yb.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testSQL {
    @Autowired
    private CustomerDao customerDao;

    /**
     * sql查询
     */
    @Test
    public void testfindAllBySQL() {
        List<Object[]> list = customerDao.findAllBySQL();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void testfindAllBySQLCondition() {
        List<Object[]> list = customerDao.findAllBySQLCondition("%三");
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    /**
     * 方法命名规则查询
     * 根据客户名称查询
     */
    @Test
    public void testfindByCustName() {
        Customer customer = customerDao.findByCustName("姚斌");
        System.out.println(customer);
    }

    /**
     * 根据客户名称模糊查询
     */
    @Test
    public void testfindByCustNameLike() {
        List<Customer> customers = customerDao.findByCustNameLike("%三");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void testfindByCustNameLikeAndCustIndustry() {
        List<Customer> customers = customerDao.findByCustNameLikeAndCustIndustry("%三","IT");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
