package org.yamikaze.spring.study.sync;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 轻量级Task测试
 * @author yamikaze
 * @date 2018/1/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:sync/task.xml")
public class SpringTaskTest {

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Test
    public void testExecutor() throws Exception{
        executor.execute(() ->
                System.out.println("Hello Spring Executor")
        );
        System.in.read();
    }

    @Test
    public void testScheduler() throws Exception{
        //单位是毫秒
        //会发现beanId为springTask的test01和test02方法被运行了
        scheduler.scheduleAtFixedRate((() ->
                System.out.println(1234567)
        ), 10000);
        System.in.read();
    }
}
