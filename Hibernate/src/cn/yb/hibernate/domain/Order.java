package cn.yb.hibernate.domain;

public class Order {
    private Integer id;//订单id，以后工作中是UUID类型
    private String name;//订单名称

    //订单只属于某个客户
    private Customer customer;
}
