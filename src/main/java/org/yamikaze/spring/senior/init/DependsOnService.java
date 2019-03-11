package org.yamikaze.spring.senior.init;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/15 14:59
 */
@Service("dep")
@DependsOn("ccc")
public class DependsOnService implements InitializingBean, DisposableBean {

    @Autowired
    private InitService initService;

    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public DependsOnService() {
        System.out.println("dependsOnService constructor is invoking.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initService is " + (initService == null));
    }
    @PreDestroy
    public void preDestory() {
        System.out.println("this is preDestory method");
    }

    public void close() {
        System.out.println("三刀是个大傻逼");
    }

    public void shutdown() {
        System.out.println("三刀是个宇宙大傻逼");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("this is my close method");
    }
}
