package org.yamikaze.spring.study.aop;

/**
 * @author qinluo
 * @date 2017/12/19
 */
public interface HelloWorld {

    /**
     * 打印出HelloWorld
     */
    void sayHello();

    /**
     * return
     * @param name
     * @return
     */
    String returnHello(String name);
}
