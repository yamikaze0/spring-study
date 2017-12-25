package org.yamikaze.spring.study.ioc.constructor;

import org.yamikaze.spring.study.ioc.SayHelloService;

import java.util.List;

/**
 * 构造函数注入数字类型，null, 引用类型，Collection类型
 * @author yamikaze
 * @date 2017/12/18
 */
public class ConstructorClass {

    private String name;
    private Integer number;
    private SayHelloService sayHelloService;
    private List<String> otherList;

    public ConstructorClass(String name, Integer number,
                            SayHelloService sayHelloService,
                            List<String> otherList) {
        this.name = name;
        this.number = number;
        this.sayHelloService = sayHelloService;
        this.otherList = otherList;
    }

    @Override
    public String toString() {
        return number + "" + name + sayHelloService.say(name) + otherList;
    }
}
