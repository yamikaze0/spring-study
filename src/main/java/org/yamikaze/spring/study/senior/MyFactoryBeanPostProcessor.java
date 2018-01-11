package org.yamikaze.spring.study.senior;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author yamikaze
 * @date 2018/1/11
 */
@Component
public class MyFactoryBeanPostProcessor implements BeanFactoryPostProcessor{

    /**
     * 支持在bean的元数据定义加入东西
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition definition = beanFactory.getBeanDefinition("userService");
        if(definition == null) {
            return;
        }

        definition.setLazyInit(true);
        definition.setPrimary(true);
        definition.setScope("singleton");
        definition.setAttribute("text", "text123");
        System.out.println("===============================");
    }

}
