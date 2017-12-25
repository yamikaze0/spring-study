package org.yamikaze.spring.study.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;
/**
 * @author yamikaze
 * @date 2017/12/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop-context-annotation.xml")
public class AopUtilsTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void testAopUtils() {
        /*当前对象是否为一个代理对象*/
        assertTrue(AopUtils.isAopProxy(helloWorld));

        /*当前对象是否采用Jdk动态代理*/
        assertTrue(AopUtils.isJdkDynamicProxy(helloWorld));
        /*当前对象是否采用cglib代理*/
        assertFalse(AopUtils.isCglibProxy(helloWorld));

        System.out.println(AopUtils.getTargetClass(helloWorld));

        Object jdkDynamicAopProxy = ReflectionUtils.getField(JdkDynamicProxy_h_FIELD, helloWorld);
        ProxyFactory proxyFactory =  (ProxyFactory) ReflectionUtils.getField(JdkDynamicAopProxy_advised_FIELD, jdkDynamicAopProxy);
        Advisor[] advisors = proxyFactory.getAdvisors();
        for(Advisor advisor : advisors) {
            System.out.println(advisor.isPerInstance() + advisor.getClass().getSimpleName());
        }
    }

    //JDK动态代理 字段相关
    private static Field JdkDynamicProxy_h_FIELD;
    private static Class JdkDynamicAopProxy_CLASS;
    private static Field JdkDynamicAopProxy_advised_FIELD;

    //ProxyFactory 相关字段
    private static Class ProxyFactory_CLASS;
    private static Field ProxyFactory_targetSource_FIELD;

    static {
        JdkDynamicProxy_h_FIELD = ReflectionUtils.findField(Proxy.class, "h");
        ReflectionUtils.makeAccessible(JdkDynamicProxy_h_FIELD);

        try {
            JdkDynamicAopProxy_CLASS = Class.forName("org.springframework.aop.framework.JdkDynamicAopProxy");
            JdkDynamicAopProxy_advised_FIELD = ReflectionUtils.findField(JdkDynamicAopProxy_CLASS, "advised");
            ReflectionUtils.makeAccessible(JdkDynamicAopProxy_advised_FIELD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            /*ignore*/
        }

        ProxyFactory_CLASS = ProxyFactory.class;
        ProxyFactory_targetSource_FIELD = ReflectionUtils.findField(ProxyFactory_CLASS, "targetSource");
        ReflectionUtils.makeAccessible(ProxyFactory_targetSource_FIELD);

    }
}
