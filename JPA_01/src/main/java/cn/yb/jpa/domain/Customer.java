package cn.yb.jpa.domain;

import javax.persistence.*;

/**
 * 客户实体类
 *      配置映射关系：
 *          1.实体类和表的映射关系
 *              @Entity：声明实体类
 *              @Table：配置实体类和表的映射关系
 *                  name：数据库表的名称
 *          2.实体类中属性和表字段的映射关系
 *              @Id：声明主键
 *              @GeneratedValue：配置主键生成策略
 *                  strategy = GenerationType.IDENTITY：自增（要求数据库底层支持自增，对id自增）mysql
 *                             GenerationType.SEQUENCE：序列（要求数据库底层支持序列）oracle
 *                             GenerationType.TABLE：JPA提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增
 *                             GenerationType.AUTO：程序自动的的帮助我们选择主键生成策略
*               @Column：配置属性和字段的映射关系
 *                  name：对应的数据库表中的字段名
 */
@Entity
@Table(name = "cst_customer")
public class Customer {

    @Id//声明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;//客户主键

    @Column(name = "cust_name")
    private String custName;//名称

    @Column(name = "cust_source")
    private String custSource;//来源

    @Column(name = "cust_industry")
    private String custIndustry;//所属行业

    @Column(name = "cust_level")
    private String custLevel;//级别

    @Column(name = "cust_address")
    private String custAddress;//地址

    @Column(name = "cust_phone")
    private String custPhone;//联系方式

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
}
