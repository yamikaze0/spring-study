package org.yamikaze.spring.study.ioc.constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring使用构造函数index注入
 * @author qinluo
 * @date 2017/12/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ioc-context-index.xml")
public class ConstructorIndexTest {

    @Autowired
    private ConstructorClass constructorClass;

    @Test
    public void testC() {
        System.out.println(constructorClass);
    }
}
