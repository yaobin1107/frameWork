package cn.yb.spring.dao.impl;

import cn.yb.spring.dao.IAccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    @Override
    public void out(String outer, Integer money) {
        String sql = "update account set money = money - ? where username = ?";
        super.getJdbcTemplate().update(sql,money,outer);
    }
    @Override
    public void in(String inner, Integer money) {
        String sql = "update account set money = money + ? where username = ?";
        super.getJdbcTemplate().update(sql,money,inner);
    }
}
