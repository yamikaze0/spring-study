package org.yamikaze.spring.study.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/1/28 17:42
 */

public class XmlStartedTest {

    @Test
    public void testXmlStart() {
        String config = "classpath:bean-merge.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        System.out.println(context.getStartupDate());

        context.destroy();
    }
}
