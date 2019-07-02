package cn.yb.service.impl;

import cn.yb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void register(String username, String password) {

        String sql = "insert into t_user(username,password) values(?,?)";
        jdbcTemplate.update(sql, username, password);
    }
}
