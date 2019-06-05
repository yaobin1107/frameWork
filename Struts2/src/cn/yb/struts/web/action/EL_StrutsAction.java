package cn.yb.struts.web.action;

import cn.yb.struts.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;

public class EL_StrutsAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //StrutsRequestWrapper
        /**
         * EL表达式取struts的数据顺序
         *  Servlet/Jsp：存数据 page,request,session,application
         *  Struts：存数据 page,request,valueStack,contextMap,session,application
         * 以前用Servlet时，jsp取数据一般从request中取
         * 如果用Struts2，jsp取数据一般从valueStack中取
         */
        return SUCCESS;
    }
}
