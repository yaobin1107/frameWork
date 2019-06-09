package cn.yb.spring.service.impl;

import cn.yb.spring.dao.IAccountDao;
import cn.yb.spring.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl03 implements IAccountService {

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
