package cn.yb.springmvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExt {
    private User user;

    List<User> usersList = new ArrayList<User>();

    private Map<String, Object> userMap = new HashMap<String, Object>();

    public Map<String, Object> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, Object> userMap) {
        this.userMap = userMap;
    }


    public List<User> getUsersList() { return usersList; }

    public void setUsersList(List<User> usersList) { this.usersList = usersList; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserExt{" +
                "user=" + user +
                ", usersList=" + usersList +
                ", userMap=" + userMap +
                '}';
    }
}
