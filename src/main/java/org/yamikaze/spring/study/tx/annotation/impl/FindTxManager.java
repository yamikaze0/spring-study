package org.yamikaze.spring.study.tx.annotation.impl;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author yamikaze
 * @date 2018/1/11
 */
@Component
public class FindTxManager implements BeanPostProcessor{

    int count = 0;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof PlatformTransactionManager) {
           System.out.println(bean.getClass().getName() + ", beanName is " + beanName + ", " + ++count);

           if(bean instanceof DataSourceTransactionManager) {
               BasicDataSource dataSource = (BasicDataSource)((DataSourceTransactionManager) bean) .getDataSource();
               System.out.println("conn url : " + dataSource.getUrl());
           }
        }
        return bean;
    }
}
