package org.yamikaze.spring.senior;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yamikaze.spring.senior.init.InitService;
import org.yamikaze.spring.senior.init.StaticClass;
import org.yamikaze.spring.senior.init.XmlConfig;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/15 15:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:senior/senior-init-order.xml")
public class SeniorInitTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private InitService initService;

    //@Autowired
    private XmlConfig xmlConfig;

    @Test
    public void test() {
        System.out.println(applicationContext);
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println(11123141);
        StaticClass.STR = "yamikaze";
    }

    @Test
    public void testProcessor() {
        System.out.println(initService == null);

        if(initService != null) {
            System.out.println(initService.getClass().getName());
            initService.testMethod();
        }

        System.out.println(xmlConfig == null);
        //System.out.println(xmlConfig.getClass().getName());
    }

    @Test
    public void test01() {
        System.out.println(initService == null);

        if(initService != null) {
            System.out.println(initService.getClass().getName());
        }
    }
}
