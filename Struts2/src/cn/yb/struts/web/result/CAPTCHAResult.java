package cn.yb.struts.web.result;

import cn.dsna.util.images.ValidateCode;
import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import javax.servlet.http.HttpServletResponse;

/**
 * 自定义结果类型（customize）验证码的结果类型
 */
public class CAPTCHAResult extends StrutsResultSupport {

    private int width;//验证码宽度
    private int height;//验证码高度

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    protected void doExecute(String s, ActionInvocation args) throws Exception {
        //生成验证码
        ValidateCode code = new ValidateCode(width, height, 4, 6);
        //获取response对象
        HttpServletResponse response = ServletActionContext.getResponse();
        //把图片返回给客户端
        code.write(response.getOutputStream());
    }
}
