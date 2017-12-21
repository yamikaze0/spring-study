package org.yamikaze.spring.study.ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.study.ioc.annotation.IncludeService;

/**
 * @author qinluo
 * @date 2017/12/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ioc-context-test.xml")
public class TestAnnotation {

    @Autowired
    private IncludeService includeService;

    @Test
    public void testA() {

    }
}
