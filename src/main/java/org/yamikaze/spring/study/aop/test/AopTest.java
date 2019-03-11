package org.yamikaze.spring.study.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 注解Component加入Spring管理
 * 注解Aspect表明这是一个切面
 * @author yamikaze
 * @date 2017/12/20
 */

@Component
@Aspect
public class AopTest {

    /**
     * 正常编写方法
     */
    @Pointcut("@annotation(ProtectedTest)")
    public void sayHelloPointcut() {

    }

    /**
     * 这儿的value可以直接是pointcut里面的东西，但是如果同一个pointcut需要复用
     * 则最好写成上面那种形式
     */
    @After(value = "sayHelloPointcut()")
    public void after() {
        System.out.println("after annotation hello world");
    }

}
