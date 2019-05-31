package cn.yb.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private Integer sid;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    private Set<Course> courses = new HashSet<>();
}
