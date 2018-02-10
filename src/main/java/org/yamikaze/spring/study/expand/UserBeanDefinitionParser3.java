package org.yamikaze.spring.study.expand;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author yamikaze
 * @date 2018/2/10
 */
public class UserBeanDefinitionParser3 implements BeanDefinitionParser{

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        AbstractBeanDefinition definition = new UserBeanDefinitionParser2().parseInternal(element, parserContext);
        String id = element.getAttribute("id");
        if (definition != null && !parserContext.isNested()) {
            try {
                //比继承AbstractBeanDefinitionParser多一步注册过程
                parserContext.getRegistry().registerBeanDefinition(id, definition);
            }
            catch (BeanDefinitionStoreException ex) {
                parserContext.getReaderContext().error(ex.getMessage(), element);
                return null;
            }
        }
        return definition;
    }
}
