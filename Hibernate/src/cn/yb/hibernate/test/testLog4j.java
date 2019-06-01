package cn.yb.hibernate.test;

import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log4j.rootLogger=warn, stdout，file
 * warn：日志级别，表示高于该级别的信息都会显示
 * log4j日志级别 ：
 *      fatal 致命错误
 *      error 错误
 *      warn 警告
 *      info 信息
 *      debug 调试信息
 *      trace 堆栈信息 （由高到底顺序）
 * stdout,file ：输出源【可以配置多个】，把数据写到哪个位置
 */
public class testLog4j {

    //创建日志对象
    Logger logger = LoggerFactory.getLogger(testLog4j.class);

    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        /**
         * 代码里使用日志：
         * 1.创建日志对象
         * 2.调用日志对象的方法
         */
        logger.error("error!");
        logger.warn("warn!");
        logger.info("info!");

        session.getTransaction().commit();
        session.close();
    }
}
