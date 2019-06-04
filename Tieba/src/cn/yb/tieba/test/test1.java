package cn.yb.tieba.test;

import cn.yb.tieba.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

public class test1 {

    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();


        session.close();
    }
}
