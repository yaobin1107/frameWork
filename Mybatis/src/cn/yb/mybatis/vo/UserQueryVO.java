package cn.yb.mybatis.vo;

import cn.yb.mybatis.model.User;

import java.util.List;

public class UserQueryVO {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    private List<Integer> ids;

}
