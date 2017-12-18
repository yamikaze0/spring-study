package org.yamikaze.spring.study.ioc.impl;

import org.yamikaze.spring.study.ioc.SayHelloService;

/**
 * @author qinluo
 * @date 2017/12/18
 */
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public int say(String name) {
        System.out.println("Hello " + name);
        return 1;
    }

}
