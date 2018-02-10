package org.yamikaze.spring.study.expand;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Objects;

/**
 * @author yamikaze
 * @date 2018/2/10
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    private static Logger logger = LoggerFactory.getLogger(UserBeanDefinitionParser.class);

    @Override
    protected Class<?> getBeanClass(Element element) {
        String clz = element.getAttribute("clz");
        try {
            if(StringUtils.isNotBlank(clz)) {
                return Class.forName(clz);
            }
            throw new ClassNotFoundException("please signal class name for current element " + element.getTagName());
        } catch (ClassNotFoundException e) {
            logger.error("not found class {}", clz);
            throw new RuntimeException(e);
        }
    }



    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String singleton = "singleton";
        String prototype = "prototype";
        String scope = element.getAttribute("scope");
        if(Objects.equals(prototype, scope)) {
            builder.setScope(scope);
        } else {
            builder.setScope(singleton);
        }

        NodeList nodeList = element.getChildNodes();
        if(nodeList == null || nodeList.getLength() <= 0) {
            return;
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
                builder.addPropertyValue(name, value);
            } else {
                builder.addPropertyReference(name, ref);
            }

        }
    }
}
