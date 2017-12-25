package org.yamikaze.spring.study.tx;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.model.User;

/**
 * @author yamikaze
 * @date 2017/12/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-context-template.xml")
public class TemplateTest {

    @Autowired
    private UserService userService;
    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setUsername("yamikaze");
        user.setPassword("yamikaze");
        user.setPhone("123456789");
    }

    @Test(expected = RuntimeException.class)
    public void testM() {
        userService.addUser(user);
    }
}
