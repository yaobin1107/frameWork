package cn.yb.spring.service;

import cn.yb.spring.service.impl.UserServiceImpl;

public class UserServiceFactory2 {
    public IUserService createUserService() {
        return new UserServiceImpl();
    }
}
