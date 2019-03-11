package org.yamikaze.spring.senior.init;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/25 20:12
 */
public class FactoryBeanTest implements FactoryBean<Boolean> {

    @Override
    public Boolean getObject() throws Exception {
        System.out.println("invoke factory bean");
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return Boolean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
