package cn.yb.service.impl;

import cn.yb.mapper.UserMapper;
import cn.yb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String username, String password) {
        userMapper.save(username, password);
    }
}
