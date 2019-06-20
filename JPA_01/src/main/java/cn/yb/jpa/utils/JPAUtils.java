package cn.yb.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 解决实体类管理器工厂浪费资源和耗时的问题
 *      通过静态代码块，当程序第一次访问此工具类时，创建一个公共的实体管理器工厂对象
 */
public class JPAUtils {

    private static EntityManagerFactory factory;

    static {
        //加载配置文件，创建实体类管理器工厂对象
        factory = Persistence.createEntityManagerFactory("myJpa");
    }

    /**
     * 获取实体管理器对象
     */
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
