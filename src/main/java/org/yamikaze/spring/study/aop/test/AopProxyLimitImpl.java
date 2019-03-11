package org.yamikaze.spring.study.aop.test;

import org.springframework.stereotype.Service;
import org.yamikaze.spring.study.aop.HelloWorld;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2018/12/11 21:46
 */

@Service("aopProxyLimitImpl")
public class AopProxyLimitImpl implements HelloWorld {

    @Override
    public void sayHello() {

    }

    @Override
    public void abc() {

    }

    @Override
    public String returnHello(String name) {
        return null;
    }

    @Override
    public String argsWithAnnotation(HelloWorld helloWorld) {
        return null;
    }

    @ProtectedTest
    private void protectedMethod() {
        System.out.println(11111);
    }
}
