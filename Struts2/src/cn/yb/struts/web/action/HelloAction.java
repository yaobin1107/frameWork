package cn.yb.struts.web.action;

/**
 * Action的第一种写法，不需要继承任何类
 * 在struts.xml中配置即可
 */
public class HelloAction {
    public String sayHello() {
        System.out.println("HelloAction的sayHello方法被调用了！");
        //int i = 10 / 0;
        return "success";
    }
}
