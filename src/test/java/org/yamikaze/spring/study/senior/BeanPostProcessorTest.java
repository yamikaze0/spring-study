package org.yamikaze.spring.study.senior;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author qinluo
 * @date 2017/12/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:senior-context-annotation.xml")
public class BeanPostProcessorTest {

    @Autowired
    public UserService userService;

    @Test
    public void testI() {

    }
}
