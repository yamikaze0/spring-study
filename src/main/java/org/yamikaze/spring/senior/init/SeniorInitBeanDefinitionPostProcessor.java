package org.yamikaze.spring.senior.init;

import org.springframework.aop.framework.autoproxy.target.LazyInitTargetSourceCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import org.yamikaze.spring.study.senior.NoSpringClass;

import java.util.Arrays;

/**
 * @author yamikaze
 * @date 2018/1/11
 */
@Component
public class SeniorInitBeanDefinitionPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("-----------------+++++++++++++++++++++" + StaticClass.STR);

        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        System.out.println("all bean definition name are " + Arrays.toString(beanDefinitionNames));

        for(String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
            if(beanDefinition.getBeanClassName() == null) {
                System.out.println("bean class name is null" + beanName);
                continue;
            }

            if(beanDefinition.getBeanClassName().contains("AutoProxyCreator")) {
                System.out.println("12fljakljlksjdlkajdasd");
            }


            if(beanName.contains(".")) {
                continue;
            }

            //beanDefinition.setLazyInit(true);

            //registry.removeBeanDefinition(beanName);

            String[] dependsOn = beanDefinition.getDependsOn();
            System.out.println("bean name " + beanName + " dependsOn are " + Arrays.toString(dependsOn));

            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();

            PropertyValue[] propertyValues1 = propertyValues.getPropertyValues();
            for(PropertyValue propertyValue : propertyValues1) {
                System.out.println(propertyValue.getName() + " ---" + propertyValue.getValue());
            }

        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
