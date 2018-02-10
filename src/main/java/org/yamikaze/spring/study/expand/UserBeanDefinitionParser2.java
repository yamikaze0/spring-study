package org.yamikaze.spring.study.expand;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Objects;

/**
 * @author yamikaze
 * @date 2018/2/10
 */
public class UserBeanDefinitionParser2 extends AbstractBeanDefinitionParser {

    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        AbstractBeanDefinition definition = (AbstractBeanDefinition) parserContext.getContainingBeanDefinition();
        String singleton = "singleton";
        String prototype = "prototype";
        String scope = element.getAttribute("scope");
        if(Objects.equals(prototype, scope)) {
            definition.setScope(scope);
        } else {
            definition.setScope(singleton);
        }

        NodeList nodeList = element.getElementsByTagName("userProperty");
        if(nodeList == null || nodeList.getLength() <= 0) {
            return definition;
        }
        for(int i = 0, length = nodeList.getLength(); i < length; i++) {
            Element node = (Element) nodeList.item(i);
            String name = node.getAttribute("name");
            String value = node.getAttribute("value");
            String ref = node.getAttribute("ref");
            if(StringUtils.isBlank(name)) {
                throw new IllegalStateException("current tag " + element.getTagName() + "'s sub tag " + node.getTagName() +
                        "'s name attribute is null");
            }
            if(StringUtils.isBlank(ref)) {
                definition.getPropertyValues().addPropertyValue(name, value);
            } else {
                definition.getPropertyValues().add(name, new RuntimeBeanReference(ref));
            }

        }
        return definition;
    }

}
