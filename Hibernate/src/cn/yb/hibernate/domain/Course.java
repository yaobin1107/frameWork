package cn.yb.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private Integer cid;
    private String name;

    private Set<Student> students= new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }

    public Course(String name) {
        this.name = name;
    }

    public Course() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
