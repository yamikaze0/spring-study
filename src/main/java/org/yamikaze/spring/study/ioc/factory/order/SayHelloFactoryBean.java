package org.yamikaze.spring.study.ioc.factory.order;

import org.springframework.beans.factory.FactoryBean;
import org.yamikaze.spring.study.ioc.impl.SayHelloServiceImpl;

/**
 * @author yamikaze
 * @date 2017/12/30
 */
public class SayHelloFactoryBean implements FactoryBean{

    @Override
    public Object getObject() throws Exception {
        System.out.println("=====");
        return new SayHelloServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return SayHelloServiceImpl.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
