package org.yamikaze.spring.study.scan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yamikaze
 * @version 1.0.0
 * @date 2018/3/20 12:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:component-scan.xml")
public class TestScan {

    @Autowired
    private ScanService scanService;

    @Test
    public void testService() {
        System.out.println(scanService == null);
    }
}
