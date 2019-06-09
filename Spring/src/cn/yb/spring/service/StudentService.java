package cn.yb.spring.service;

import cn.yb.spring.dao.IUserDao;
import cn.yb.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class StudentService {

    public void addStudent() {
        System.out.println("添加学生_addStudent");
    }

    public void deleteStudent() {
        System.out.println("删除学生_deleteStudent");
    }

    public void updateStudent() {
        System.out.println("更新学生_updateStudent");
    }

    public int deleteStudent(int id) {
        System.out.println("通过id删除学生_ deleteStudent(int id)");
        return id;
    }
}
