package cn.yb.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //可用于多个对象共同的事情的处理（这个配置对所有对象有效）
        System.out.println("5.User_预处理：" + bean + ":" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //可用于多个对象共同的事情的处理（这个配置对所有对象有效）
        System.out.println("8.User_后处理：" + bean + ":" + beanName);
        return bean;
    }
}
