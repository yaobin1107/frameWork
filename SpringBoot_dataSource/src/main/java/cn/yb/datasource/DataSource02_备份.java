/*
package cn.yb.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration//注解到springboot容器中
@MapperScan(basePackages = "cn.yb.mybatis2.mapper", sqlSessionFactoryRef = "mybatis2SqlSessionFactory")
public class DataSource02_备份 {

    */
/**
 * @return 返回mybatis2数据库的数据源
 * @return 返回mybatis2数据库的会话工厂
 * @return 返回mybatis2数据库的事务
 * @return 返回mybatis2数据库的会话模版
 *//*

    @Bean(name = "mybatis2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mybatis2")
    public DataSource dateSource() {
        return DataSourceBuilder.create().build();
    }

    */
/**
 * @return 返回mybatis2数据库的会话工厂
 *//*

    @Bean(name = "mybatis2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("mybatis2DataSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);

        return bean.getObject();
    }

    */
/**
 * @return 返回mybatis2数据库的事务
 *//*

    @Bean(name = "mybatis2TransactionManager")
    @Primary//主事务
    public DataSourceTransactionManager transactionManager(@Qualifier("mybatis2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    */
/**
 * @return 返回mybatis2数据库的会话模版
 *//*

    @Bean(name = "mybatis2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("mybatis2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
*/
