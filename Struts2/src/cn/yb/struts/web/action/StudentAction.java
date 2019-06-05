package cn.yb.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

    public String addStudent() {
        System.out.println("addStudent");
        return SUCCESS;
    }
    public String deleteStudent() {
        System.out.println("deleteStudent");
        return SUCCESS;
    }

    public String updateStudent() {
        System.out.println("updateStudent");
        return SUCCESS;
    }

    public String findStudent() {
        System.out.println("findStudent");
        return SUCCESS;
    }
}
