package cn.yb.tieba.web.filter;

import cn.yb.tieba.utils.HibernateUtils;
import org.hibernate.Session;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("事务拦截器");
        //1.开启事务
        Session session = HibernateUtils.getCurrentSession();
        System.out.println("doFilter:" + session.hashCode());
        session.getTransaction().begin();
        try {
            //2.放行,让它执行action代码
            filterChain.doFilter(request, response);
            if (session != null && session.isOpen()) {
                //3.提交事务
                session.getTransaction().commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
            //回滚
            session.getTransaction().rollback();
        }
        //4.关闭session【与线程绑定的session是不需要关闭，会自动关闭】
        //session.close();
    }

    @Override
    public void destroy() {

    }
}
