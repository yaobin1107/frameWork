package cn.yb.spring.service;

import cn.yb.spring.service.impl.UserServiceImpl;

public class UserServiceFactory {
    public static IUserService createUserService() {
        return new UserServiceImpl();
    }
}
