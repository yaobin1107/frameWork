package cn.yb.spring.dao;

public interface IAccountDao {

    public void out(String outer,Integer money);

    public void in(String inner,Integer money);

}
