package org.yamikaze.spring.study.aop.xml;

/**
 * @author qinluo
 * @date 2017/12/19
 */
public class XmlAopAspect {

    public void beforeSayHello() {
        System.out.println("before say hello");
    }

    public void afterSayHello() {
        System.out.println("after say hello");
    }
}
