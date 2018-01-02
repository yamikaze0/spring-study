package org.yamikaze.spring.study.ioc.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.study.ioc.factory.order.IncludeSayHelloService;

/**
 * @author yamikaze
 * @date 2017/12/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ioc-context-factory-seq.xml")
public class AutowiredOrderTest {

    @Autowired
    private IncludeSayHelloService service;

    @Test
    public void testO() {
        service.say();
    }
}
