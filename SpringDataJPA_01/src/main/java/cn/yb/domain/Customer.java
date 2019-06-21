package cn.yb.domain;

import javax.persistence.*;

/**
 * 实体类和表的映射关系
 *
 * @Entity
 * @Table 类中属性和表中字段的映射关系
 * @Id
 * @GeneratedValue
 * @Column
 */

@Entity
@Table(name = "cst_customer")//数据库表名
public class Customer {
    @Id//声明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键增长策略
    @Column(name = "cust_id")//name是对应数据库表中的列名
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
