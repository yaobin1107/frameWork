package cn.yb.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private Integer id;
    private String name;//客户名称

    //一对多，一个客户有多个订单
    private Set<Order> orders = new HashSet<Order>();
}
