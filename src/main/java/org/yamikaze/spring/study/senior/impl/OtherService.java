package org.yamikaze.spring.study.senior.impl;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 * @author yamikaze
 * @date 2018/1/10
 */
@Service
public class OtherService {

    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass().getName() + " destroy ...");
    }
}
