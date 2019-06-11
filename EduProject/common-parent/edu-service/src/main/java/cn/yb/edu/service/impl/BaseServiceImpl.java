package cn.yb.edu.service.impl;


import cn.yb.edu.mapper.UserMapper;
import cn.yb.edu.service.base.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    //统一管理dao
    @Autowired
    protected UserMapper userMapper;

}
