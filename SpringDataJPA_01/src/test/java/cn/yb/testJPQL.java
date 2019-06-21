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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testJPQL {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindByJPQL() {
        Customer customer = customerDao.findByJPQL("姚斌");
        System.out.println(customer);
    }

    @Test
    public void testFinNameAndId() {
        Customer customer = customerDao.finNameAndId("张三", 6L);
        System.out.println(customer);
    }

    /**
     * 更新
     * SpringDataJPA中使用jpql完成 更新/删除 操作时：
     * ✓需要手动添加事务支持
     * ✓SpringDataJPA默认执行结束后会回滚事务
     */
    @Test
    @Transactional//添加事务支持
    @Rollback(value = false)//关闭自动回滚
    public void testUpdateNameById() {
        customerDao.updateNameById(3L, "李四");
    }
}
