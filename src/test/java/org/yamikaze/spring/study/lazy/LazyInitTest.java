package org.yamikaze.spring.study.lazy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试延迟初始化
 * @author qinluo
 * @date 2017/12/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:lazy-context.xml")
public class LazyInitTest {

    @Autowired
    private HokaGe hokaGe;

    @Test
    public void testLazy() {

    }
}
