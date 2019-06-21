package cn.yb.dao;

import cn.yb.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JPA接口规范
 * ☛1.需要继承两个接口，JpaRepository,JpaSpecificationExecutor
 * ☛JpaRepository<操作实体类类型，实体类中主键属性的类型>
 * ☛☛封装了基本CRUD操作
 * ☛JpaSpecificationExecutor<操作的实体类类型>
 * ☛☛封装了复杂查询（分页）
 * ☛2.需要提供相应的泛型
 */
public interface CustomerDao extends JpaRepository<Customer, Long>,
        JpaSpecificationExecutor<Customer> {

    /**
     * 根据客户名称查询客户,使用jpql的形式查询
     * jpql：from Customer where custName = ?
     * 配置JPQL语句：在接口上使用@Query注解，属性value写jpql语句
     */
    @Query(value = "from Customer where custName = ?1")
    public Customer findByJPQL(String custName);

    /**
     * 根据客户名称和客户id查询数据库
     * jpql：from Customer where custName = ? and custId = ?
     * 对于多个参数占位符：
     * 赋值时，默认情况下，占位符的位置需要和方法参数中的位置保持一致
     * 也可以指定占位符参数的位置：
     * ?后面加索引，指定此占位符的取值来源
     */
    @Query(value = "from Customer where custName = ?1 and custId = ?2")
    public Customer finNameAndId(String name, Long id);

    /**
     * 根据id更新客户名称
     * jpql：update Customer set custName=? where custId=?
     *
     * @Query：代表的是查询 ✓要声明此方法是用来更新的：@Modifying
     */
    @Query(value = "update Customer set custName=?2 where custId=?1")
    @Modifying
    public void updateNameById(Long Id, String name);

    /**
     * SQL语句的查询：
     * ☛1.特有的查询，需要在dao接口上配置
     * ☛2.在方法上使用注解形式配置 SQL 查询语句
     * ☛3.注解：@Query
     * ☛ value：jpql语句 / sql语句
     * ☛ nativeQuery：false（jpql查询） / true（使用本地查询，SQL查询）
     */
    @Query(value = "select * from cst_customer", nativeQuery = true)
    public List<Object[]> findAllBySQL();

    @Query(value = "select * from cst_customer where cust_name like ?", nativeQuery = true)
    public List<Object[]> findAllBySQLCondition(String name);

    /**
     * 方法命名规则查询
     * 有几个约定：
     * ☛ findBy：查询，后面跟对象中的属性名称，首字母大写
     * 例如：findByCustName 根据客户名称查询
     * ☛ 在SpringDataJPA运行阶段会根据方法名称进行解析：
     * ☛ ☛ findBy解析为 from XXX（实体类）
     * ☛ ☛ 后面的属性名称解析为 where custName = (他自己将首字母变为小写)
     */
    public Customer findByCustName(String name);
}
