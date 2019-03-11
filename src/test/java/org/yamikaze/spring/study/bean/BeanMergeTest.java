package org.yamikaze.spring.study.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.study.bean.merge.HelloApi;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/1/28 17:42
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-merge.xml")
public class BeanMergeTest {

    @Autowired
    private ApplicationContext context;

    //@Autowired
    private HelloApi helloApi;

    @Test
    public void testMerge() {
        System.out.println(1111);
        helloApi.say();
    }

    @Test
    public void testGetBean() {
        System.out.println(context == null);
    }
}
