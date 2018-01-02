package org.yamikaze.spring.study.ioc.factory.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yamikaze.spring.study.ioc.SayHelloService;

/**
 * @author yamikaze
 * @date 2017/12/30
 */
@Service
public class IncludeSayHelloService {

    @Autowired
    private SayHelloService sayHelloService;

    public void say() {
        sayHelloService.say("12");
    }
}
