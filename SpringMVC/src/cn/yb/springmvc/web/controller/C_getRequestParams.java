package cn.yb.springmvc.web.controller;

import cn.yb.springmvc.model.User;
import cn.yb.springmvc.model.UserExt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;

@Controller
public class C_getRequestParams {

    @RequestMapping("/toRegister1")
    public String toRegister1() {
        return "/user/register";
    }

    /**
     * 第一种获取请求参函数的方式：接收int String Date 数组类型
     * 默认日期格式：1.月/日/年 -->10/10/2016
     *              2.年/月/日 -->1996/10/10(不能为空)
     * @return
     */
    @RequestMapping("/register1")
    public String register1(String username, String password,
                           String gender, Date birthday, String[] hobby) {
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("性别："+gender);
        System.out.println("生日："+birthday);
        System.out.println("爱好："+Arrays.toString(hobby));

        return "/user/info";
    }

    @RequestMapping("/toRegister2")
    public String toRegister2() {
        return "/user/register";
    }

    /**
     * 第二种获取请求参函数的方式：接收模型参数
     * 默认日期格式：1.月/日/年 -->10/10/2016
     *               2.年/月/日 -->1996/10/10(不能为空)
     * @return
     */
    @RequestMapping("/register2")
    public String register2(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getGender());
        System.out.println(user.getBirthday());
        System.out.println(Arrays.toString(user.getHobby()));

        return "/user/info";
    }

    @RequestMapping("/toRegister3")
    public String toRegister3() {
        return "/user/register";
    }

    /**
     * 第三种获取请求参函数的方式:接收包装类型参数（模型里面有模型）
     * 默认日期格式：1.月/日/年 -->10/10/2016
     *               2.年/月/日 -->1996/10/10 (不能为空)
     * @return
     */
    @RequestMapping("/register3")
    public String register3(UserExt userExt) {
        System.out.println(userExt);
        return "/user/info";
    }

    @RequestMapping("/toRegister4")
    public String toRegister4() {
        return "/user/register";
    }

    /**
     * 第四种获取请求参函数的方式:接收集合类型参数（模型里面有集合List，List里面存模型）
     * 默认日期格式：1.月/日/年 -->10/10/2016
     *               2.年/月/日 -->1996/10/10 (不能为空)
     * @return
     */
    @RequestMapping("/register4")
    public String register4(UserExt userExt) {
        System.out.println(userExt.getUsersList());
        return "/user/info";
    }

    @RequestMapping("/toRegister5")
    public String toRegister5() {
        return "/user/register";
    }

    /**
     * 第五种获取请求参函数的方式:接收Map类型参数（模型里面有集合Map，Map里面存模型）
     * 默认日期格式：1.月/日/年 -->10/10/2016
     *               2.年/月/日 -->1996/10/10 (不能为空)
     * @return
     */
    @RequestMapping("/register5")
    public String register5(UserExt userExt) {
        System.out.println("接收到的参数："+userExt.getUserMap());
        return "/user/info";
    }
}
