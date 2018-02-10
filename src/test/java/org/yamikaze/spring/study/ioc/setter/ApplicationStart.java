package org.yamikaze.spring.study.ioc.setter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qinluo
 * @date 2017/12/18
 */
public class ApplicationStart {

    private BeanFactory factory;

    @Before
    public void setUp() {
        factory = new ClassPathXmlApplicationContext("classpath:ioc-context-setter.xml");
    }

    @Test
    public void testS() {
        System.out.println(factory.getBean("sayHello"));
    }
}
