package org.yamikaze.spring.study.aop.xml;

import org.yamikaze.spring.study.aop.HelloWorld;

/**
 * @author qinluo
 * @date 2017/12/19
 */
public class XMlHelloWorldImpl implements HelloWorld{

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }

    @Override
    public String returnHello(String name) {
        return null;
    }
}
