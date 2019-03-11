package org.yamikaze.spring.senior.init;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/25 16:27
 */
@Component
@Aspect
public class AopAspect2 {

    /**
     * 正常编写方法
     */
    @Pointcut("execution( * org.yamikaze.spring.senior.init.InitService.testMethod(..))")
    public void sayHelloPointcut() {
    }

    /**
     * 如果有参数 加上 && arg(param), 这儿不会生效，因为sayHello方法是无参的
     */
    @Before(value = "sayHelloPointcut()")
    public void before() {
        System.out.println("sayHelloPointcut 2");
    }
}
