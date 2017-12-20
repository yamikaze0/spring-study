package org.yamikaze.spring.study.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author qinluo
 * @date 2017/12/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop-context-xml.xml")
public class XmlAopTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void testSayHelloWorld() {
        helloWorld.sayHello();
    }
}
