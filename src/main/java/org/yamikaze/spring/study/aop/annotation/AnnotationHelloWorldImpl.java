package org.yamikaze.spring.study.aop.annotation;

import org.springframework.stereotype.Service;
import org.yamikaze.spring.study.aop.HelloWorld;
import org.yamikaze.spring.study.aop.PrivateTest;
import org.yamikaze.spring.study.aop.TestAnnotation;
import org.yamikaze.spring.study.aop.WithinAnnotation;

/**
 * @author yamikaze
 * @date 2017/12/19
 */
@Service("annotationHelloWorldService")
@TestAnnotation
@WithinAnnotation
public class AnnotationHelloWorldImpl implements HelloWorld{

    @Override
    public void sayHello() {
        System.out.println("Hello annotation");
        abc();
    }

    @PrivateTest
    @Override
    public void abc() {
        System.out.println(11111);
    }

    @Override
    @TestAnnotation
    public String returnHello(@TestAnnotation String name) {
        System.out.println("enter......");
        return "hello" + name;
    }

    @Override
    public String argsWithAnnotation(@TestAnnotation HelloWorld helloWorld) {
        System.out.println("with annotation arg");
        return "";
    }
}
