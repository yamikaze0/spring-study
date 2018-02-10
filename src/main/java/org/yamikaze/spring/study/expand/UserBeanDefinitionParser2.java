package org.yamikaze.spring.study.expand;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
        if(definition == null) {
            definition = new GenericBeanDefinition();
            definition.setBeanClass(User.class);
        }
        String singleton = "singleton";
        String prototype = "prototype";
        String scope = element.getAttribute("scope");
        if(Objects.equals(prototype, scope)) {
            definition.setScope(scope);
        } else {
            definition.setScope(singleton);
        }

        NodeList nodeList = element.getChildNodes();
        if(nodeList == null || nodeList.getLength() <= 0) {
            return definition;
        }
        for(int i = 0, length = nodeList.getLength(); i < length; i++) {
            Node node = nodeList.item(i);
            //注意必须判断为Element才能强转
            if(!Element.class.isInstance(node)) {
                continue;
            }
            Element ele = (Element) node;
            String name = ele.getAttribute("name");
            String value = ele.getAttribute("value");
            String ref = ele.getAttribute("ref");
            if(StringUtils.isBlank(name)) {
                throw new IllegalStateException("current tag " + element.getTagName() + "'s sub tag " + ele.getTagName() +
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
