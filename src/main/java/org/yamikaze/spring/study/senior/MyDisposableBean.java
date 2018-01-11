package org.yamikaze.spring.study.senior;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

/**
 * @author yamikaze
 * @date 2018/1/10
 */
@Service
public class MyDisposableBean implements DisposableBean {

    /**
     * 包含当前实例的FactoryBean销毁时会调用这个方法
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy bean ......");
    }
}
