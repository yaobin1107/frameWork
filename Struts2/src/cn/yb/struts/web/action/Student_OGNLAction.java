package cn.yb.struts.web.action;

import cn.yb.struts.model.Student_OGNL;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class Student_OGNLAction extends ActionSupport {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student_OGNL> getStuList() {
        return stuList;
    }

    //action提供属性，并提供get方法，这个属性数据就会被存到valueStack
    private List<Student_OGNL> stuList;

    public String list() {

        //jsp一般从valueStack拿数据
        stuList = new ArrayList<Student_OGNL>();
        stuList.add(new Student_OGNL("yb1", 12, "西安1"));
        stuList.add(new Student_OGNL("yb2", 13, "西安2"));
        stuList.add(new Student_OGNL("yb3", 14, "西安3"));
        stuList.add(new Student_OGNL("yb4", 15, "西安4"));
        stuList.add(new Student_OGNL("yb5", 16, "西安5"));

        System.out.println(username);
        System.out.println(password);

        return SUCCESS;
    }
}
