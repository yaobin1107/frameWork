package cn.yb.mybatis1.service;

import cn.yb.mybatis1.mapper.UserMapper;
import cn.yb.mybatis2.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomerMapper customerMapper;

    public void save(String username, String password) {
        customerMapper.save(username, "12345678910");
        //int i = 10 / 0;
        userMapper.save(username, password);
    }
}
