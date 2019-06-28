package cn.yb.mybatis1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 注解配置
     */
    @Insert("insert into user(username,password) values(#{username},#{password})")
    public int save(@Param("username") String username, @Param("password") String password);
}
