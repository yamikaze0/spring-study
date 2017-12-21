package org.yamikaze.spring.study.ioc.annotation;

import org.yamikaze.spring.study.ioc.SayHelloService;

/**
 * @author qinluo
 * @date 2017/12/21
 */
public class SayHelloServiceXmlImpl implements SayHelloService{

    @Override
    public int say(String name) {
        return 0;
    }
}
