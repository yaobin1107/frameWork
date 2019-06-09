package cn.yb.spring.service;

import cn.yb.spring.model.User;

public interface IUserService {
    public void deleteUser();

    public void updateUser();

    public int deleteUser(int id);

    public void add();

    public void add(User user);
    //AOP 切面编程

    public void addUser();

}
