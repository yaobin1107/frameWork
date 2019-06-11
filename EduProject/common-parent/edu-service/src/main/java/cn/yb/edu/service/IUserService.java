package cn.yb.edu.service;

import cn.yb.edu.model.User;
import cn.yb.edu.service.base.IBaseService;

public interface IUserService extends IBaseService<User> {
    //写特有的方法
    public User login(String username, String password);
}
