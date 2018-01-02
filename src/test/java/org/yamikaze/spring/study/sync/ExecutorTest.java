package org.yamikaze.spring.study.sync;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 集成Executor & Scheduler
 * 配置参考 sync/executor.xml
 * @author yamikaze
 * @date 2018/1/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:sync/executor.xml")
public class ExecutorTest {

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Test
    public void testExecutor() {
        executor.execute(() ->
            System.out.println("Hello Spring Executor")
        );
    }

    @Test
    public void testScheduler() throws Exception{
        //单位是毫秒
        scheduler.scheduleAtFixedRate((() ->
            System.out.println(1234567)
        ), 10000);

    }
}
