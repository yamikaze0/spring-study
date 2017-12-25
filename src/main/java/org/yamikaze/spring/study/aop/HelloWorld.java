package org.yamikaze.spring.study.aop;

/**
 * @author yamikaze
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

    /**
     * 测试参数带有注解的方法，这儿注解采用Spring的Service
     * @param helloWorld
     * @return
     */
    String argsWithAnnotation(HelloWorld helloWorld);

}
