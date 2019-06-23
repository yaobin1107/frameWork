package cn.yb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 注解配置
     */
    @Insert("insert into t_user(username,password) values(#{username},#{password})")
    public int save(@Param("username") String username, @Param("password") String password);
}
