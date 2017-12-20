package org.yamikaze.spring.study.aop.annotation;

import org.springframework.stereotype.Service;
import org.yamikaze.spring.study.aop.HelloWorld;

/**
 * @author qinluo
 * @date 2017/12/19
 */
@Service("annotationHelloWorld")
public class AnnotationHelloWorldImpl implements HelloWorld{

    @Override
    public void sayHello() {
        System.out.println("Hello annotation");
    }

    @Override
    public String returnHello(String name) {
        System.out.println("enter......");
        return "hello" + name;
    }
}
