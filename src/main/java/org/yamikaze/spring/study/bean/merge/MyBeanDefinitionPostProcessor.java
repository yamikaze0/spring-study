package org.yamikaze.spring.study.bean.merge;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import org.yamikaze.spring.study.senior.NoSpringClass;

/**
 * @author yamikaze
 * @date 2018/1/11
 */
@Component
public class MyBeanDefinitionPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName(MergeApiImpl.class.getName());
        beanDefinition.setScope("singleton");
        beanDefinition.setLazyInit(true);
        beanDefinition.setAbstract(false);
        beanDefinition.setAutowireCandidate(true);
        registry.registerBeanDefinition("helloApi", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
