package cn.yb.struts.dao.impl;

import cn.yb.struts.dao.IUserDao;
import cn.yb.struts.model.User;
import cn.yb.struts.utils.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public int addUser(User user) {
        //1.queryRunner
        QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "insert into user values(?,?,?,?,?)";
        try {
            return qr.update(sql, user.getUsername(),
                    user.getPassword(), user.getBirthday(), user.getHobby(), user.isMarried());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
