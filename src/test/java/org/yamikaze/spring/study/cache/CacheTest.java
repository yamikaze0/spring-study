package org.yamikaze.spring.study.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.study.cache.service.CacheServiceImpl;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author qinluo
 * @version 1.0.0
 * @date 2018/5/14 13:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cache.xml")
public class CacheTest {

    @Resource
    private CacheServiceImpl cacheService;

    @Test
    public void testCache() throws InterruptedException{
        System.out.println(cacheService.getAllData().size());

        TimeUnit.SECONDS.sleep(1);

        System.out.println(cacheService.getAllData().size());
        TimeUnit.SECONDS.sleep(3);

        System.out.println(cacheService.getAllData().size());
        TimeUnit.SECONDS.sleep(5);

        System.out.println(cacheService.getAllData().size());

        TimeUnit.SECONDS.sleep(59);

        System.out.println(cacheService.getAllData().size());

    }

    @Test
    public void testScheduleCache() throws InterruptedException {
        int index = 10;

        do {
            System.out.println(cacheService.getAllData().size());
            TimeUnit.SECONDS.sleep(3);
        } while(--index > 0);
    }

}
