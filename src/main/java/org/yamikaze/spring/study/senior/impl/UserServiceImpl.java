package org.yamikaze.spring.study.senior.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.yamikaze.spring.study.senior.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yamikaze
 * @date 2017/12/20
 */
@Service("userService")
@Scope
public class UserServiceImpl implements UserService{

    @Value("name")
    private String text;

    public String getText() {
        return text;
    }

    /**
     * init方法将会在实例化、初始化后调用
     */
    @PostConstruct
    public void init() {
        System.out.println("I'm init..." + text);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("I'm destroy ...");
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserServiceImpl() {
        System.out.println("userService");
    }
}
