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

    /**
     * 方法上有java.lang.Override注解
     * 加到实现类的方法上，而不是接口，实现类
     * 且注解的范围必须是RUNTIME
     */
    @Before(value = "@annotation(org.yamikaze.spring.study.aop.TestAnnotation)")
    public void ar() {
        System.out.println("ar");
    }

    /**
     * beanId以Service结尾的方法
     */
    @Before(value = "bean(*Service)")
    public void bean() {
        System.out.println("bean");
    }

    /**
     * 匹配一个参数带有TestAnnotation的方法
     * 暂时不知道怎么使用
     */
    @Before(value = "@args(org.yamikaze.spring.study.aop.TestAnnotation)")
    public void args() {
        System.out.println("@args");
    }

    /**
     * 对类上带有TestAnnotation注解的方法有效
     * 注解放到类上，而不是接口、方法、参数
     */
    @Before(value = "@target(org.yamikaze.spring.study.aop.TestAnnotation)")
    public void target() {
        System.out.println("target");
    }

    /**
     * 只有目标类型持有这个注解就有效
     * 注解放在类上，而不是接口、方法、参数上
     */
    @Before(value = "@within(org.yamikaze.spring.study.aop.WithinAnnotation)")
    public void within() {
        System.out.println("within");
    }

    /**
     * 匹配参数为String的方法
     * 区别与@args
     */
    @Before(value = "args(java.lang.String)")
    public void arg() {
        System.out.println("arg not @args");
    }

    /**
     * 匹配实现了HelloWorld接口的类
     */
    @Before(value = "target(org.yamikaze.spring.study.aop.HelloWorld)")
    public void target1() {
        System.out.println("target not @target");
    }

    /**
     * within(org.yamikaze..*) org.yamikaze任意包下的任意方法
     * within(org.yamikaze.HelloWorld) org.yamikaze.HelloWorld的任意方法
     * within(org.yamikaze.HelloWorld+) org.yamikaze.HelloWorld类型的任意方法
     * within(@org.yamikaze.TestAnnotation *) 持有TestAnnotation注解的任意方法
     */
    @Before(value = "within(org.yamikaze.spring.study.aop.HelloWorld+)")
    public void within1() {
        System.out.println("within not @within");
    }

    /**
     * 注解在类上, 与@within保持一致
     */
    @Before(value = "within(@org.yamikaze.spring.study.aop.WithinAnnotation *)")
    public void within2() {
        System.out.println("within2 not @within");
    }


}
