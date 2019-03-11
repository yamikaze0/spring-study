package org.yamikaze.spring.senior.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/15 14:59
 */
//@DependsOn("dep")
@Service("ccc")
public class InitService implements InitializingBean {

    @Autowired
    //@Qualifier("dep")
    private DependsOnService dependsOnService;

    public InitService() {
        System.out.println("initService constructor is invoking.....");
    }

    public void testMethod() {
        System.out.println("this is initService's test method.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("dependsOnService is " + (dependsOnService == null) + " abc = ");
    }

    public void close() {
        System.out.println("哈哈哈哈哈哈哈哈哈");
    }

    //@Bean("depc")
    public DependsOnService newDepends() {
        return new DependsOnService();
    }

}
