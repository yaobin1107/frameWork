package cn.yb.mybatis2.service;

import cn.yb.mybatis2.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl {

    @Autowired
    private CustomerMapper customerMapper;

    public void save(String name, String tel) {
        customerMapper.save(name, tel);
    }
}
