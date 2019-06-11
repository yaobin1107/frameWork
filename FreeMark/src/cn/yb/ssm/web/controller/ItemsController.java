package cn.yb.ssm.web.controller;

import cn.yb.ssm.model.Items;
import cn.yb.ssm.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping("list")
    public String list(Model model){
        //1.查询数据
        List<Items> itemsList = iItemService.findAllItems();
        //System.out.println(itemsList);
        //2.存数据
        model.addAttribute("itemsList",itemsList);
        return "items/list";
    }

    @RequestMapping("save")
    public String save(){
        Items items = new Items();
        items.setCreatetime(new Date());
        items.setDetail("测试事务");
        items.setName("事务");
        items.setPrice(1000.00F);
        iItemService.saveOrUpdate(items);
        return "items/list";
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        iItemService.deleteById(id);
        return "forward:list.do";
    }

    @RequestMapping("edit")
    public String edit(Integer id, Model model){
        //System.out.println("id:"+id);
        //通过id找到商品
        Items itemsById = iItemService.findItemsById(id);
        if (itemsById != null) {
            model.addAttribute("itemsById",itemsById);
        }
        return "items/edit";
    }

    @RequestMapping("update")
    public String update(Items items, Model model){
        //System.out.println(items);
        items.setCreatetime(new Date());
        iItemService.saveOrUpdate(items);
        return "forward:list.do";
    }

    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("myname","test freemark");
        return "items/hello";
    }
}
