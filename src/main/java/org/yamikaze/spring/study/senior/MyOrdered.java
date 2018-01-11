package org.yamikaze.spring.study.senior;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author yamikaze
 * @date 2018/1/10
 */
@Component
public class MyOrdered implements PriorityOrdered, BeanPostProcessor {

    /**
     * 多个BeanPostProcessor的执行顺序就是添加到列表时候的顺序，如果实现了
     * PriorityOrdered接口的类具有高优先级，下列方法返回的值越小则优先级越高
     * 或者直接实现Ordered接口，但优先级低于PriorityOrdered
     * @return order
     */
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before" + this.getClass().getName() + "," + bean.getClass().getName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after" + this.getClass().getName() + "," + bean.getClass().getName());
        return bean;
    }
}
