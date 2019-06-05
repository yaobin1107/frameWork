package cn.yb.struts.service.impl;

import cn.yb.struts.dao.IUserDao;
import cn.yb.struts.dao.impl.UserDaoImpl;
import cn.yb.struts.model.User;
import cn.yb.struts.service.IUserService;

public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        userDao.addUser(user);
    }
}
