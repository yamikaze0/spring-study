package org.yamikaze.spring.senior.init;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 注解Component加入Spring管理
 * 注解Aspect表明这是一个切面
 * @author yamikaze
 * @date 2017/12/20
 */

@Component
@Aspect
public class AopAspect {

    /**
     * 正常编写方法 Advisor
     */
    @Pointcut("execution( * org.yamikaze.spring.senior.init.AopAspect2.before(..))")
    public void aop() {

    }

    /**
     * 如果有参数 加上 && arg(param), 这儿不会生效，因为sayHello方法是无参的
     */
    @Before(value = "aop()")
    public void before() {
        System.out.println("sayHelloPointcut 1");
    }
}
