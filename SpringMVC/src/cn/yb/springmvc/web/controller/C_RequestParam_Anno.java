package cn.yb.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_RequestParam_Anno {

    //参数前面加@RequestParam(value = "XX", required = true)说明 XX 这个参数必填！
    //defaultValue = "30" 设置此参数的默认值
    //否则报错：Required Integer parameter 'uid' is not present
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(value = "uid", required = true, defaultValue = "30") Integer uid) {
        System.out.println("uid:" + uid);
        return "/user/register";
    }
}
