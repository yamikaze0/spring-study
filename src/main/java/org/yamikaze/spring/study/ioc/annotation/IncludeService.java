package org.yamikaze.spring.study.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.yamikaze.spring.study.ioc.SayHelloService;

/**
 * @author yamikaze
 * @date 2017/12/21
 */
public class IncludeService {

    private SayHelloService sayHelloXmlService;

    private SayHelloService sayHelloAnnotationService;

    public SayHelloService getSayHelloXmlService() {
        return sayHelloXmlService;
    }

    public void setSayHelloXmlService(SayHelloService sayHelloXmlService) {
        this.sayHelloXmlService = sayHelloXmlService;
        System.out.println("sayHelloAnnotationService : " + (sayHelloAnnotationService == null));

    }

    public SayHelloService getSayHelloAnnotationService() {
        return sayHelloAnnotationService;
    }

    @Autowired
    public void setSayHelloAnnotationService(SayHelloService sayHelloAnnotationService) {
        this.sayHelloAnnotationService = sayHelloAnnotationService;
        System.out.println("sayHelloXmlService : " + (sayHelloXmlService == null));
    }
}
