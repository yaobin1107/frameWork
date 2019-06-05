package cn.yb.struts.web.action;

import cn.yb.struts.model.Student;
import cn.yb.struts.service.IUserService;
import cn.yb.struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction_Add extends ActionSupport implements ModelDriven<Student> {

    private Student student = new Student();

    @Override
    public Student getModel() {
        return student;
    }

    public String add() {
        System.out.println(student);
        return NONE;
    }
}
