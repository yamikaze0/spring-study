package org.yamikaze.spring.study.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2018/9/30 16:41
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrivateTest {}
