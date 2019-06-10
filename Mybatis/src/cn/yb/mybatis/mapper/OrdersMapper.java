package cn.yb.mybatis.mapper;

import cn.yb.mybatis.model.Orders;
import cn.yb.mybatis.model.OrdersExt;

import java.util.List;

public interface OrdersMapper {

    //扩展类
    public OrdersExt findOrderById(int id);

    public Orders findOrderById2(int id);

    public Orders findOrderById3(int id);

    public List<Orders> findOrderAndUserByLazyLoading();
}
