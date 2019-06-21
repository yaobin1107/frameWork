package cn.yb.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;

    /**
     * 注解的形式配置一对多关系
     *      1.声明关系
     *          @ManyToMany：配置多对多关系
     *              targetEntity：对方对象的字节码对象
     *      2.配置外键（中间表）
     *          @JoinTable：配置中间表
     *              name：中间表名
     *              joinColumns 当前对象在中间表中的外键
     *                  @JoinColumn的数组
     *                      name：外键名
     *                      referencedColumnName：参照主表主键名
     *              inverseJoinColumns 对方对象在中间表中的外键
     *                  @JoinColumn的数组
     *                      name：外键名
     *                      referencedColumnName：参照主表主键名
     */
//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "t_user_role",
//            //joinColumns 当前对象在中间表中的外键
//            joinColumns = {@JoinColumn(name = "frk_role_id",referencedColumnName = "role_id")},
//            //inverseJoinColumns 对方对象在中间表中的外键
//            inverseJoinColumns ={@JoinColumn(name = "frk_user_id",referencedColumnName = "user_id")})
    @ManyToMany(mappedBy = "roles")
    Set<User> users = new HashSet<User>();

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
