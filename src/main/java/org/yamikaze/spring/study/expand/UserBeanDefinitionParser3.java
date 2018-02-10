package org.yamikaze.spring.study.expand;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author yamikaze
 * @date 2018/2/10
 */
public class UserBeanDefinitionParser3 implements BeanDefinitionParser{

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return new UserBeanDefinitionParser2().parseInternal(element, parserContext);
    }
}
