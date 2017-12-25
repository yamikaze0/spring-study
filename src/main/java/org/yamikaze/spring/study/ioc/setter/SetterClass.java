package org.yamikaze.spring.study.ioc.setter;

import org.yamikaze.spring.study.ioc.SayHelloService;

import java.util.List;

/**
 * @author yamikaze
 * @date 2017/12/18
 */
public class SetterClass {

    private String name;
    private Integer number;
    private SayHelloService sayHelloService;
    private List<String> otherList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SayHelloService getSayHelloService() {
        return sayHelloService;
    }

    public void setSayHelloService(SayHelloService sayHelloService) {
        this.sayHelloService = sayHelloService;
    }

    public List<String> getOtherList() {
        return otherList;
    }

    public void setOtherList(List<String> otherList) {
        this.otherList = otherList;
    }

    @Override
    public String toString() {
        return number + "" + name + sayHelloService.say(name) + otherList;
    }
}
