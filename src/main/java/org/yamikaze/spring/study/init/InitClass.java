package org.yamikaze.spring.study.init;

import java.util.concurrent.TimeUnit;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2018/9/4 18:46
 */
public class InitClass {

    public String name;

    public String getName() {
        return name;
    }

    public void init() throws InterruptedException {
        new Thread() {

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    name = "yamikaze";
                } catch (Exception e) {

                }
            }
        }.start();
    }
}
