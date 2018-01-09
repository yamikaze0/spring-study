package org.yamikaze.spring.study.aop;

import org.junit.Test;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring提供的泛型Api
 * @author yamikaze
 * @date 2018/1/4
 */
public class ResolveTypeTest {

    private ResolvableType resolvableType = ResolvableType.forType(List.class);

    @Test
    public void test() {
        System.out.println(resolvableType.hasGenerics());

        ResolvableType method = ResolvableType.forMethodReturnType(ReflectionUtils.findMethod(ResolveTypeTest.class, "get"));

        System.out.println("method return type = " + method.getGeneric(0).resolve());
    }

    private List<String> get() {
        return new ArrayList<>(1);
    }

}
