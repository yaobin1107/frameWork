package cn.yb.ssm.service;

import cn.yb.ssm.model.Items;

import java.util.List;

public interface IItemService {

    public List<Items> findAllItems();

    public Items findItemsById(Integer id);

    public void saveOrUpdate(Items items);

    public void deleteById(Integer id);
}
