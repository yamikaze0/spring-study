package org.yamikaze.spring.study.definition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.study.expand.User;

/**
 * @author yamikaze
 * @date 2018/2/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/definitionBean.xml")
public class DefinitionTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test() {
        User user = context.getBean("user", User.class);
        System.out.println(user.getUsername());
        System.out.println(user);
    }

    @Test
    public void test02() {
        User user = context.getBean(User.class);
        System.out.println(user.getUsername());
    }
}
