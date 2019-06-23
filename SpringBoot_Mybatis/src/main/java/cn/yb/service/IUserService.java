package cn.yb.service;

import cn.yb.model.User;

public interface IUserService {

    public void register(String username, String password);

    public User findUserByUsername(String username);
}
