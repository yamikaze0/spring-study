package org.yamikaze.spring.study.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.study.ioc.test.IncludeService;

/**
 * @author qinluo
 * @version 1.0.0
 * @date 2018/5/23 18:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dependsOn.xml")
public class TestInclude {

    @Autowired
    private HelloWorld helloWorld;

    @Autowired
    private ApplicationContext context;

    @Test
    public void test() {
        System.out.println(helloWorld.getName());
    }


}
