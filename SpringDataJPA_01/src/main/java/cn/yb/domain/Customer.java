package cn.yb.domain;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    //客户与联系人之间的关系（一对多）
    /**
     * 注解的形式配置一对多关系
     *      1.声明关系
     *          @OneToMany：配置一对多关系
     *              targetEntity：对方对象的字节码对象
     *      2.配置外键（中间表）
     *          @JoinColumn：配置外键
     *              name：外键名
     *              referencedColumnName：对应主表的主键字段名
     * 在客户实体类上（一的一方）添加了外键配置，对于客户而言就有了维护外键的义务
     */

//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")

    /**
     * 放弃外键维护权：
     *      @OneToMany(mappedBy = "customer")
     *          mappedBy：对方配置了外键维护方式的属性名（参照对方属性上的外键维护方式来做）
     *          cascade：配置级联（可以配置到多表映射关系上）
     *              CascadeType.ALL
     *              CascadeType.REMOVE
     *              CascadeType.MERGE
     *              CascadeType.PERSIST
     *          fetch：配置加载策略
     *              FetchType.EAGER：立即加载
     *              FetchType.LAZY：懒加载
     */
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<LinkMan> linkMens = new HashSet<LinkMan>();

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

    public Set<LinkMan> getLinkMens() {
        return linkMens;
    }

    public void setLinkMens(Set<LinkMan> linkMens) {
        this.linkMens = linkMens;
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
