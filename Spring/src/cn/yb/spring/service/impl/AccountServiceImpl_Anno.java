package cn.yb.spring.service.impl;

import cn.yb.spring.dao.IAccountDao;
import cn.yb.spring.service.IAccountService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
@Transactional
public class AccountServiceImpl_Anno implements IAccountService {
    private IAccountDao accountDao;
    //提供set方法，让spring注入
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void transfer(String outer, String inner, Integer money) {
        accountDao.out(outer, money);
        accountDao.in(inner, money);
    }
}
