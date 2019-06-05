package cn.yb.struts.web.action;

import cn.yb.struts.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

public class GetValueByOGNLAction extends ActionSupport {

    private String username = "新增username属性提供get方法";

    //如果action中有get方法，他会把这个数据存在valueStack中
    public String getUsername() {
        return username;
    }

    @Override
    public String execute() throws Exception {

        //1.往ValueStack存数据
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        /**
         * push():往栈顶放数据
         */
        valueStack.push(new User("User对象的username属性1", "1234561"));
        //valueStack.push(new User("User对象的username属性2", "1234562"));
        /**
         * setValue():更改栈顶的对应key的值
         * 如果没有对应key，报错！
         * valueStack.setValue("#username", "Map_username");
         * 如果没有对应key相当于往contextMap中存数据
         * 如果有对应key相当于往修改对应key的数据
         * 注意：修改属性值要提供set方法
         */
        valueStack.setValue("username", "修改了username");
        //valueStack.setValue("#username", "Map_username");
        //valueStack.setValue("#username", "Map_username2");
        /**
         * set()方法：往值栈存Map数据
         */
        valueStack.set("user", new User("valueStack的set方法", "valueStack的set方法"));


        //2.往contextMap存数据
        ActionContext contextMap = ActionContext.getContext();
        contextMap.put("contextMap", "hai~");

        //3.往contextMap的session存数据
        contextMap.getSession().put("contextMap_session", "contextMap_session");

        //3.往contextMap的request存数据
        ServletActionContext.getRequest().setAttribute("contextMap_request", "contextMap_request");

        //3.往contextMap的application存数据
        contextMap.getApplication().put("contextMap_application", "contextMap_application");

        return SUCCESS;
    }
}
