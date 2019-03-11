package org.yamikaze.spring.senior.init;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.aop.framework.autoproxy.target.LazyInitTargetSourceCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/15 15:03
 */
@Component("abcProcessor")
//@DependsOn("ccc")
public class InitializingBeanPostProcessor
        implements InstantiationAwareBeanPostProcessor, PriorityOrdered,
        BeanDefinitionRegistryPostProcessor, BeanFactoryAware, InitializingBean {

    @Autowired
    private InitService initService;

    private BeanFactory beanFactory;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition beanDefinition1 = new GenericBeanDefinition();
        beanDefinition1.setBeanClassName(LazyInitTargetSourceCreator.class.getName());
        beanDefinition1.setScope("singleton");
        beanDefinition1.setLazyInit(false);
        beanDefinition1.setAbstract(false);
        beanDefinition1.setAutowireCandidate(true);
        registry.registerBeanDefinition("myBean", beanDefinition1);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

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
        System.out.println("bean before init. beanName " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean after init. beanName " + beanName);
        if(beanName.contains("internalAutoProxyCreator") && (bean instanceof AnnotationAwareAspectJAutoProxyCreator)) {
            LazyInitTargetSourceCreator bean1 = beanFactory.getBean("myBean", LazyInitTargetSourceCreator.class);
            if(bean1 != null) {
                ((AnnotationAwareAspectJAutoProxyCreator)bean) .setCustomTargetSourceCreators(bean1);
            }

        }

        return bean;
    }

    public InitializingBeanPostProcessor() {
        System.out.println("==========================================" + StaticClass.STR + " ---" + (initService == null));
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initService isiiiiiiii + " + (initService == null));
    }
}
