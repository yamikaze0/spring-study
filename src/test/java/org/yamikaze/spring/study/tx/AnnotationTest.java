package org.yamikaze.spring.study.tx;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.yamikaze.model.User;

/**
 * @author yamikaze
 * @date 2017/12/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "tx")
@Transactional
@ContextConfiguration("classpath:tx-context-annotation.xml")
public class AnnotationTest {

    @Autowired
    private UserService userService;
    private User user;

    @Autowired
    private PlatformTransactionManager tx;

    @Before
    public void setUp() {
        user = new User();
        user.setUsername("yamikaze");
        user.setPassword("yamikaze");
        user.setPhone("123456789");
    }

    /**
     * 事务管理器。
     * 当有多个事务管理器存在时，且这些事务管理器当中不存在beanName为transactionManager的事务管理器
     * 那么@Transactional注解上不给value值将会报错，通过value属性执行beanName则正常(但找不到bean依旧会报错)
     * 如果beanName为transactionManager的事务管理器存在，而@Transactional没有指定value
     * 那么发生异常时就不会被回滚，此时相当于插入数据没有开启事务，因为开启的事务是其他数据库的。
     *
     */
    @Test(expected = RuntimeException.class)
    public void testM() {
        userService.addUser(user);
    }

    @Test
    public void testTx() {
        System.out.println(tx == null ? 0 : tx.getClass().getName());
    }
}
