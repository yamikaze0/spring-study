package org.yamikaze.spring.study.ioc.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.study.ioc.SayHelloService;

/**
 * @author yamikaze
 * @date 2017/12/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ioc-context-factory.xml")
public class FactoryTest {

    @Autowired
    private SayHelloService sayHelloService;

    @Test
    public void testF() {
        System.out.println(sayHelloService);
    }
}
