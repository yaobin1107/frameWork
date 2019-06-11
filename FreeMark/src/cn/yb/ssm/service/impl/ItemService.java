package cn.yb.ssm.service.impl;

import cn.yb.ssm.mapper.ItemsMapper;
import cn.yb.ssm.model.Items;
import cn.yb.ssm.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService implements IItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> findAllItems() {
        return itemsMapper.findAllItems();
    }

    @Override
    public Items findItemsById(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Items items) {
        if (items.getId() == null) {
            itemsMapper.insert(items);
            //int i = 10/0;
        } else {
            //这个方法在更新数据时会更新不全，看源码就可以知道
            //itemsMapper.updateByPrimaryKey(items);
            itemsMapper.updateByPrimaryKeySelective(items);
        }

    }

    @Override
    public void deleteById(Integer id) {
        itemsMapper.deleteByPrimaryKey(id);
    }

}
