package cn.yb.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action的第三种写法
 * 继承ActionSupport类（com.opensymphony.xwork2.ActionSupport）
 * struts.xml中action没有配置method会默认执行其父类ActionSupport的execute方法
 * 一般这种方法最常用！
 */
public class HelloAction3 extends ActionSupport {

}
