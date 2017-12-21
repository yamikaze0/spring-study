package org.yamikaze.spring.study.tx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.model.User;

/**
 * @author qinluo
 * @date 2017/12/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-context-aop.xml")
public class XmlAopTest {

    @Autowired
    private UserService userService;

    /**
     * 应当抛出RuntimeException,并且数据库数据已经回滚
     */
    @Test(expected = RuntimeException.class)
    public void testX() {
        User user = new User();
        user.setUsername("yamikaze");
        user.setPassword("yamikaze");
        user.setPhone("123456789");
        userService.addUser(user);
    }
}
