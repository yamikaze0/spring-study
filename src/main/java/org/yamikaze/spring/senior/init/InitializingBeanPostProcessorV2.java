package org.yamikaze.spring.senior.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/15 15:03
 */
@Component("v2InitalizingBeanPostProcessor")
public class InitializingBeanPostProcessorV2 implements InstantiationAwareBeanPostProcessor, InitializingBean, Ordered {

    //@Autowired
    private InitService initService;

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("V2 bean before init. beanName " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("bean after init. beanName " + beanName);
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Hello ya" + (initService == null));

        if(initService != null) {
            System.out.println(initService.getClass().getName());
        }
    }

    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
