package cn.yb.struts.web.action;

import cn.yb.struts.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

public class ValueStackAction extends ActionSupport {
    @Override
    public String execute() throws Exception {

        //往ValueStack存数据
        //第一种获取ValueStack对象的方法
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        //存数据
        valueStack.push(new User("valueStack_push", "123456"));
        //valueStack.set("texts", "valueStack_set");
        //valueStack.setValue(String s,Object o),通过key修改对应值
        valueStack.setValue("birthday", "1996-11-07");

        //第二种获取valueStack的方法
        ValueStack valueStack2 = (ValueStack) ServletActionContext.getRequest().getAttribute("struts.valueStack");
        System.out.println(valueStack);
        System.out.println(valueStack2);
        return SUCCESS;
    }
}
