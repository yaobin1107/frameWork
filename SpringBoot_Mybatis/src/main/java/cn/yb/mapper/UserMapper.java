package cn.yb.mapper;

import cn.yb.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 注解配置
     */
    /*@Insert("insert into t_user(username,password) values(#{username},#{password})")
    public int save(@Param("username") String username, @Param("password") String password);

    @Select("select * from t_user where username = #{username}")
    public User findUserByUsername(@Param("username") String username);*/

    /**
     * xml配置
     */
    public int save(String username, String password);

    public User findUserByUsername(String username);
}
