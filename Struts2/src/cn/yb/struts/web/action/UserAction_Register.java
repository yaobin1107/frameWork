package cn.yb.struts.web.action;

import cn.yb.struts.model.User;
import cn.yb.struts.service.IUserService;
import cn.yb.struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class UserAction_Register extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    /**
     * Struts2自带表单字段验证
     * 第一种：重写validate方法
     * 如果数据不对，可以往FieldError添加字段错误信息
     * 注意：
     * 1.这种方式的字段验证依赖Struts的from表单，标签（<s:form></s:form>,<s:textfield></s:textfield>）
     * 2.addFieldError里的key时表单的name属性值
     * 3.validate()方法对于Action来说时全局的，也就是说action的所有方法都会生效进行字段验证
     */
    /*@Override
    public void validate() {
        //判断用户名是否为空
        //if (user.getUsername() == null && "".equals(user.getUsername()))
        if (StringUtils.isEmpty(user.getUsername())) {
            addFieldError("username", "用户名不能为空");
        }
        //判断密码是否为空
        if (StringUtils.isEmpty(user.getPassword())) {
            addFieldError("password", "密码不能为空");
        }
    }*/

    /**
     * 第二种：写一个方法，格式：validate+方法名（首字母大写）
     * 这种方式是局部的字段校验，只针对方法有效
     * 例：public String validateRegister() {}
     */

    public String register() {
        /**
         * Struts2在使用模型驱动注入参数时，会自动类型转化
         * Servlet接收表单参数都是字符串类型
         * Struts2会把String类型转为Date，boolean等等
         * 如果时checkbox的表单，会议逗号+空格拼接成字符串【'学习, 游戏'】
         */
        IUserService userService = new UserServiceImpl();
        System.out.println(user);
        return NONE;
    }

    /**
     * 在不需要验证的方法上声明@SkipValidation可以跳过该方法的字段验证
     */
    //@SkipValidation
    public String list() {
        return "list";
    }
}
