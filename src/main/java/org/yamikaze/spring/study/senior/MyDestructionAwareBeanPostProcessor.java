package org.yamikaze.spring.study.senior;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yamikaze
 * @date 2017/12/21
 */
@Component
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    /**
     * 所有bean实例销毁前都会执行这个方法
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        //执行销毁方法前的处理
        System.out.println("before destroy method... bean is " + bean.getClass().getName());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
