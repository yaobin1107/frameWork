package cn.yb.mybatis.mapper;

import cn.yb.mybatis.model.User;
import cn.yb.mybatis.vo.UserQueryVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //注解配置方式
    //@Insert("insert into user (username,sex,birthday,address) value (#{username},#{sex},#{birthday},#{address});")
    public int save(User user);

    public User findUserById(int id);

    //通过模型的包装类查询用户
    public List<User> findUserByUserQueryVo(UserQueryVO userQueryVO);

    public List<User> findUserByMap(Map<String, Object> map);

    //返回用户个数
    public int findUserCount(UserQueryVO userQueryVO);

    //返回结果类型是resultMap
    public User findUserByIdResultMap(int userId);

    //mybatis动态sql（if和where）
    public List<User> findUserList(UserQueryVO userQueryVO);

    //查找多个id的用户数据（foreach）传入包装类
    public List<User> findUserByIds(UserQueryVO userQueryVO);

    //查找多个id的用户数据（foreach）直接传入集合
    public List<User> findUserByIds2(List<Integer> ids);

    //多对多，查询用户信息及用户购买的商品信息
    public List<User> findUserAndOrderInfo();
}
