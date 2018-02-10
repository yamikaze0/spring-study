package org.yamikaze.spring.study.expand;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author yamikaze
 * @date 2018/2/10
 */
public class UserNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
        registerBeanDefinitionParser("user2", new UserBeanDefinitionParser2());
        registerBeanDefinitionParser("user3", new UserBeanDefinitionParser3());
    }


}
