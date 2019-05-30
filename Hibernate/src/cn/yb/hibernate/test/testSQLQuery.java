package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.List;

public class testSQLQuery {

    /**
     * SQLQuery对象的使用
     */
    @Test
    public void test1() {
        //1.获取核心 配置文件对象,默认是加载src的hibernate.cfg.xm文件
        Configuration cfg = new Configuration().configure();
        //2.创建会话工厂
        final SessionFactory factory = cfg.buildSessionFactory();
        //3.创建会话
        Session session = factory.openSession();
        //创建SQLQuery查询对象
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
        //sqlQuery.setParameter(0,"参数");
        //执行查询
        //返回数据封装到集合，集合装数组
        List<Object[]> list = sqlQuery.list();
        for (Object[] users : list) {
            for (Object user : users) {
                System.out.println(user);
            }
            System.out.println("=========");
        }
        //4.关闭会话
        session.close();
        //5.关闭工厂，释放资源
        factory.close();
    }
}
