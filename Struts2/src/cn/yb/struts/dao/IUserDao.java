package cn.yb.struts.dao;

import cn.yb.struts.model.User;

import java.sql.SQLException;

public interface IUserDao {
    public int addUser(User user);
}
