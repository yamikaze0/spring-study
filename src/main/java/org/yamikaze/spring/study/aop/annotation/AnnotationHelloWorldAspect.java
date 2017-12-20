package org.yamikaze.spring.study.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 注解Component加入Spring管理
 * 注解Aspect表明这是一个切面
 * @author qinluo
 * @date 2017/12/20
 */

@Component
@Aspect
public class AnnotationHelloWorldAspect {

    /**
     * 正常编写方法
     */
    @Pointcut("execution( * org.yamikaze.spring.study.aop.annotation.AnnotationHelloWorldImpl.sayHello())")
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

    /**
     * 如果有参数 加上 && arg(param), 这儿不会生效，因为sayHello方法是无参的
     */
    @Before(value = "sayHelloPointcut() && args(param)")
    public void before(String param) {
        System.out.println("before ");
    }

    @Around(value = "execution( String org.yamikaze.spring.study.aop.annotation.AnnotationHelloWorldImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        //pjp 表示方法对象
        System.out.println("around before");
        Object obj = null;
        try {
            /*
             *  如果方法有返回值，需要返回，这个切点的方法也要返回相应的值，否则返回null
             *  如果返回值类型不一致，ClassCastException
             *  但是如果这儿返回了，后面就不会在运行了
             *  所以不能直接return
             */
            obj = pjp.proceed();
        } catch (Throwable t) {

        }
        System.out.println("around after");
        return obj;

    }

    @AfterReturning(value = "execution(@annotation(java.lang.Override))")
    public void ar() {
        System.out.println("ar");
    }
}
