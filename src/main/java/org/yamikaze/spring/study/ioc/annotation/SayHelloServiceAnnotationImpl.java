package org.yamikaze.spring.study.ioc.annotation;

import org.springframework.stereotype.Service;
import org.yamikaze.spring.study.ioc.SayHelloService;

/**
 * @author yamikaze
 * @date 2017/12/21
 */
@Service("sayHelloAnnotationServic1e")
public class SayHelloServiceAnnotationImpl implements SayHelloService{

    @Override
    public int say(String name) {
        return 0;
    }
}
