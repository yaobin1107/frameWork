package cn.yb.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 多对多关系
     */
    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL )
    @JoinTable(name = "t_user_role",
            //joinColumns 当前对象在中间表中的外键
            joinColumns = {@JoinColumn(name = "frk_user_id",referencedColumnName = "user_id")},
            //inverseJoinColumns 对方对象在中间表中的外键
            inverseJoinColumns ={@JoinColumn(name = "frk_role_id",referencedColumnName = "role_id")})
    Set<Role> roles = new HashSet<Role>();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
