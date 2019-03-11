package org.yamikaze.spring.study.bean.merge;

import org.springframework.stereotype.Service;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/1/28 17:40
 */
@Service("helloApi")
public class HelloApiImpl implements HelloApi {

    @Override
    public void say() {
        System.out.println("say hello!");
    }
}
