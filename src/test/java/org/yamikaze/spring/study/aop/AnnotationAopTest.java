package org.yamikaze.spring.study.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yamikaze
 * @date 2017/12/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop-context-annotation.xml")
public class AnnotationAopTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void testA() {
        helloWorld.sayHello();
    }

    @Test
    public void testR() {
        String result = helloWorld.returnHello("yamikaze");
        //为空,改正切点方法返回值为Object
        System.out.println(result);
        /* execution( pattern)
         *  pattern                           mean
         *
         *  public * *(..)                    任何公共方法的执行
         *
         *  * org.yamikaze.HelloWorld.*()     org.yamikaze.HelloWorld下任意参数为空的方法
         *
         *  * org.yamikaze..*.*(..)           org.yamikaze任意子包的任意类的任意方法(参数任意，返回值任意)
         *
         *  * org.yamikaze..HelloWorld.*(*)   org.yamikaze任意子包下HelloWorld只有一个参数的任意返回值的方法
         *
         *  ! org.yamikaze..HelloWorld+.*(..) 除了org.yamikaze任意子包下的HelloWorld类型及其子类型的任意方法
         *
         *  org.yamikaze..HelloWord+.*()      org.yamikaze任意子包下为HelloWorld类型及其子类型的任意无参方法
         *
         *  org.yamikaze.HelloWorld*.say*(java.util.Date)
         *                                    org.yamikaze包下以HelloWorld作为前缀，并且方法明前缀为say，并且方法参数声明为Date
         *
         *  org.yamikaze.HelloWorld*.say*(..) throws FileNotFoundException, ArrayIndexOutOfBoundException
         *                                    org.yamikaze包下以HelloWorld作为前缀，并且方法前缀为say,任意参数，并且声明抛出了这两个异常的方法
         *
         * (cn.javass..IPointcutService+ && java.io.Serializable+).*(..)
         *                                    任何实现了cn.javass包及所有子包下IPointcutService接口和java.io.Serializable接口的类型的任何方法
         *
         * @java.lang.Deprecated * *(..)      任何持有@java.lang.Deprecated注解的方法
         *
         * @java.lang.Deprecated @cn.javass..Secure  * *(..)
         *                                    任何持有@java.lang.Deprecated和@cn.javass..Secure注解的方法
         *
         * @(java.lang.Deprecated || cn.javass..Secure) * *(..)
         *                                    任何持有@java.lang.Deprecated或@ cn.javass..Secure注解的方法
         *
         * (@cn.javass..Secure  *)  *(..)
         *                                    任何返回值类型持有@cn.javass..Secure的方法
         *
         * (@cn.javass..Secure *).*(..)       任何定义方法的类型持有@cn.javass..Secure的方法
         *
         *  * *(@cn.javass..Secure (*) , @cn.javass..Secure (*))
         *                                     任何签名带有两个参数的方法，且这个两个参数都被@ Secure标记了，
         *                                     如public void test(@Secure String str1,
         *                                     @Secure String str1);
         *
         *  * *((@ cn.javass..Secure *))
         *                                     任何带有一个参数的方法，且该参数类型持有@ cn.javass..Secure；
         *                                     如public void test(Model model);且Model类上持有@Secure注解
         *
         *  * *(@cn.javass..Secure (@cn.javass..Secure *) ,@ cn.javass..Secure (@cn.javass..Secure *))
         *                                     任何带有两个参数的方法，且这两个参数都被@ cn.javass..Secure标记了；
         *                                     且这两个参数的类型上都持有@ cn.javass..Secure；
         *
         * * *(java.util.Map<cn.javass..Model, cn.javass..Model>, ..)
         *                                     任何带有一个java.util.Map参数的方法，且该参数类型是以< cn.javass..Model, cn.javass..Model >
         *                                     为泛型参数；注意只匹配第一个参数为java.util.Map,不包括子类型；
         *                                     如public void test(HashMap<Model, Model> map, String str);将不匹配，必须使用“* *(
         *                                     java.util.HashMap<cn.javass..Model,cn.javass..Model>, ..)”进行匹配；
         *                                     而public void test(Map map, int i);也将不匹配，因为泛型参数不匹配
         *
         * * *(java.util.Collection<@cn.javass..Secure *>)
         *                                     任何带有一个参数（类型为java.util.Collection）的方法，且该参数类型是有一个泛型参数，该泛型参数类型上持有@cn.javass..Secure注解；
         *                                     如public void test(Collection<Model> collection);Model类型上持有@cn.javass..Secure
         *
         *  * *(java.util.Set<? extends HashMap>)
         *                                     任何带有一个参数的方法，且传入的参数类型是有一个泛型参数，该泛型参数类型继承与HashMap；
         *                                     Spring AOP目前测试不能正常工作
         *
         *  * *(java.util.List<? super HashMap>)任何带有一个参数的方法，且传入的参数类型是有一个泛型参数，该泛型参数类型是HashMap的基类型；如public voi test(Map map)；
         *                                      Spring AOP目前测试不能正常工作
         *
         *  * *(*<@cn.javass..Secure *>)        任何带有一个参数的方法，且该参数类型是有一个泛型参数，该泛型参数类型上持有@cn.javass..Secure注解；
         *                                      Spring AOP目前测试不能正常工作
         */
    }

    @Test
    public void testArg() {
        helloWorld.argsWithAnnotation(helloWorld);
    }
}
