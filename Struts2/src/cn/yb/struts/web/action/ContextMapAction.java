package cn.yb.struts.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class ContextMapAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //System.out.println(this);
        //往contextMap存数据
        //1.获取ActionContext
        ActionContext contextMap = ActionContext.getContext();

        //2.往contextMap存数据
        contextMap.put("testContextMap", "hai~");

        //3.往contextMap的session存数据
        contextMap.getSession().put("contextMap_session", "contextMap_session");

        //3.往contextMap的request存数据
        ServletActionContext.getRequest().setAttribute("contextMap_request", "contextMap_request");

        //3.往contextMap的application存数据
        contextMap.getApplication().put("contextMap_application", "contextMap_application");

        /**
         * session,request,application也可以通过ServletActionContext来获取
         * ServletActionContext.getRequest()
         * ServletActionContext.getRequest().getSession()
         * ServletActionContext.getServletContext()
         */
        return SUCCESS;
    }
}
