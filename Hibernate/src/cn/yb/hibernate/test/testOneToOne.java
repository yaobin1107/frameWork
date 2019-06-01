package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Address;
import cn.yb.hibernate.domain.Company;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

public class testOneToOne {
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        Company company1 = new Company();
        company1.setName("姚斌责任有限公司");
        Address address1 = new Address();
        address1.setName("西安长安区");

        address1.setCompany(company1);
        session.save(company1);
        session.save(address1);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();

        Company company = (Company) session.get(Company.class, 1);
        System.out.println("公司名称：" + company.getName());
        System.out.println("公司地址：" + company.getAddress().getName());

        session.getTransaction().commit();
        session.close();
    }
}
