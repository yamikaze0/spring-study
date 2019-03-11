package org.yamikaze.spring.study.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yamikaze
 * @date 2017/12/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop-test-annotation.xml")
public class AnnotationAopV2Test {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    @Qualifier("aopProxyLimitImpl")
    private HelloWorld proxyLimit;

    @Test
    public void testGetBean() {
        Object bean = applicationContext.getBean("aopProxyLimitImpl");
        System.out.println(bean.getClass().getName());
        System.out.println(proxyLimit.getClass().getName());

        proxyLimit.abc();
        proxyLimit.sayHello();
    }
}
