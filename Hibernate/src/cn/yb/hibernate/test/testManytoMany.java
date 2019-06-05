package cn.yb.hibernate.test;

import cn.yb.hibernate.domain.Course;
import cn.yb.hibernate.domain.Student;
import cn.yb.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

public class testManytoMany {

    /**
     * 保存多对多数据
     * 注意事项：
     * 1.配置级联保存
     * 2.如果在映射文件中配置了inverse=”true",表示由course表来维护外键关系，导致中间表没有数据
     * 3.如果在映射文件中没有配置inverse,表示由student表来维护外键关系，中间表有数据
     * 4.在有一边设置了inverse=”true"时，哪边配置了inverse=”false"，session保存时保存哪边
     * 5.不能两边都为true
     */
    @Test
    public void test1() {
        //1.创建session
        Session session = HibernateUtils.openSession();
        session.getTransaction().begin();
        //创建两个学生
        Student student1 = new Student("王五");
        Student student2 = new Student("刘能");
        //创建两个课程
        Course course1 = new Course("数学");
        Course course2 = new Course("语文");
        Course course3 = new Course("英语");
        //绑定课程到学生
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student2.getCourses().add(course1);
        student2.getCourses().add(course2);
        student2.getCourses().add(course3);
        //保存
        session.save(student1);
        session.save(student2);
        session.getTransaction().commit();
        //4.关闭会话
        session.close();
    }
}
