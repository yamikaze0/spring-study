package org.yamikaze.spring.study.sync.task;

import org.springframework.stereotype.Component;

/**
 * @author yamikaze
 * @date 2018/1/2
 */
@Component("springTask")
public class MySpringTask {

    public void test01() {
        System.out.println("test01");
    }

    public void test02() {
        System.out.println("test02");
    }

    private void test03() {
        System.out.println("test03");
    }

    void test04() {
        System.out.println("test04");
    }

    protected void test05() {
        System.out.println("test05");
    }

}
