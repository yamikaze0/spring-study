package org.yamikaze.spring.study.sync;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 3.0以后已经不支持Timer继承，相应的timer包已经删除
 * 建议使用SchedulerExecutor来代替
 * 理由：
 * 1、Timer运行的任务有一个发生异常中断，其他任务会一起中断，而SchedulerExecutor则没有这个问题
 * 2、需要给线程一个有意义的名称以便于发生异常时排查
 * 3、当线程发生异常时(未捕获的情况下)，可以使用线程工程设置UnCaughtExceptionHandler处理
 * @author yamikaze
 * @date 2018/1/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:sync/timer.xml")
public class TimerTest {
}
