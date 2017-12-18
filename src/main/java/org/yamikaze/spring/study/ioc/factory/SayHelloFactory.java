package org.yamikaze.spring.study.ioc.factory;

import org.yamikaze.spring.study.ioc.SayHelloService;
import org.yamikaze.spring.study.ioc.impl.SayHelloServiceImpl;

/**
 * @author qinluo
 * @date 2017/12/18
 */
public class SayHelloFactory {

    public static SayHelloService getInstance(String name) {
        System.out.println("=====" + name);
        return new SayHelloServiceImpl();
    }
}
