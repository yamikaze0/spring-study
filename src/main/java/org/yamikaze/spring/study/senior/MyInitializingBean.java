package org.yamikaze.spring.study.senior;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yamikaze
 * @date 2018/1/10
 */
@Component
public class MyInitializingBean implements InitializingBean {

    @Value("yamikaze")
    private String username;

    /**
     * 在初始化后调用，调用顺序晚于BeanPostProcessor
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName() + ", username = " + (username == null));
    }
}
