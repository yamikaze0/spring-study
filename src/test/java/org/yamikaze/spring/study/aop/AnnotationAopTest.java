package org.yamikaze.spring.study.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author qinluo
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
        /** execution( pattern)
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
         *  * *((@ cn.javass..Secure *))或
          * *(@ cn.javass..Secure *)
         任何带有一个参数的方法，且该参数类型持有@ cn.javass..Secure；
         如public void test(Model model);且Model类上持有@Secure注解
          * *(
         @cn.javass..Secure (@cn.javass..Secure *) ,
         @ cn.javass..Secure (@cn.javass..Secure *))
         任何带有两个参数的方法，且这两个参数都被@ cn.javass..Secure标记了；且这两个参数的类型上都持有@ cn.javass..Secure；

          * *(
         java.util.Map<cn.javass..Model, cn.javass..Model>
         , ..)
         任何带有一个java.util.Map参数的方法，且该参数类型是以< cn.javass..Model, cn.javass..Model >为泛型参数；注意只匹配第一个参数为java.util.Map,不包括子类型；
         如public void test(HashMap<Model, Model> map, String str);将不匹配，必须使用“* *(
         java.util.HashMap<cn.javass..Model,cn.javass..Model>
         , ..)”进行匹配；
         而public void test(Map map, int i);也将不匹配，因为泛型参数不匹配
          * *(java.util.Collection<@cn.javass..Secure *>)
         任何带有一个参数（类型为java.util.Collection）的方法，且该参数类型是有一个泛型参数，该泛型参数类型上持有@cn.javass..Secure注解；
         如public void test(Collection<Model> collection);Model类型上持有@cn.javass..Secure
          * *(java.util.Set<? extends HashMap>)
         任何带有一个参数的方法，且传入的参数类型是有一个泛型参数，该泛型参数类型继承与HashMap；
         Spring AOP目前测试不能正常工作
          * *(java.util.List<? super HashMap>)
         任何带有一个参数的方法，且传入的参数类型是有一个泛型参数，该泛型参数类型是HashMap的基类型；如public voi test(Map map)；
         Spring AOP目前测试不能正常工作
          * *(*<@cn.javass..Secure *>)
         任何带有一个参数的方法，且该参数类型是有一个泛型参数，该泛型参数类型上持有@cn.javass..Secure注解；
         Spring AOP目前测试不能正常工作

         二、within：使用“within(类型表达式)”匹配指定类型内的方法执行；
         模式
         描述
         within(cn.javass..*)
         cn.javass包及子包下的任何方法执行
         within(cn.javass..IPointcutService+)
         cn.javass包或所有子包下IPointcutService类型及子类型的任何方法
         within(@cn.javass..Secure *)
         持有cn.javass..Secure注解的任何类型的任何方法
         必须是在目标对象上声明这个注解，在接口上声明的对它不起作用

         三、this：使用“this(类型全限定名)”匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能包括引入接口方法也可以匹配；注意this中使用的表达式必须是类型全限定名，不支持通配符；

         模式
         描述
         this(cn.javass.spring.chapter6.service.IPointcutService)
         当前AOP对象实现了 IPointcutService接口的任何方法
         this(cn.javass.spring.chapter6.service.IIntroductionService)
         当前AOP对象实现了 IIntroductionService接口的任何方法
         也可能是引入接口



         四、target：使用“target(类型全限定名)”匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就不包括引入接口也类型匹配；注意target中使用的表达式必须是类型全限定名，不支持通配符；
         模式
         描述
         target(cn.javass.spring.chapter6.service.IPointcutService)
         当前目标对象（非AOP对象）实现了 IPointcutService接口的任何方法
         target(cn.javass.spring.chapter6.service.IIntroductionService)
         当前目标对象（非AOP对象） 实现了IIntroductionService 接口的任何方法
         不可能是引入接口




         五、args：使用“args(参数类型列表)”匹配当前执行的方法传入的参数为指定类型的执行方法；注意是匹配传入的参数类型，不是匹配方法签名的参数类型；参数类型列表中的参数必须是类型全限定名，通配符不支持；args属于动态切入点，这种切入点开销非常大，非特殊情况最好不要使用；
         模式
         描述
         args (java.io.Serializable,..)
         任何一个以接受“传入参数类型为 java.io.Serializable” 开头，且其后可跟任意个任意类型的参数的方法执行，args指定的参数类型是在运行时动态匹配的







         六、@within：使用“@within(注解类型)”匹配所以持有指定注解类型内的方法；注解类型也必须是全限定类型名；
         模式
         描述
         @within cn.javass.spring.chapter6.Secure)
         任何目标对象对应的类型持有Secure注解的类方法；
         必须是在目标对象上声明这个注解，在接口上声明的对它不起作用






         七、@target：使用“@target(注解类型)”匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解；注解类型也必须是全限定类型名；
         模式
         描述
         @target (cn.javass.spring.chapter6.Secure)
         任何目标对象持有Secure注解的类方法；
         必须是在目标对象上声明这个注解，在接口上声明的对它不起作用



         八、@args：使用“@args(注解列表)”匹配当前执行的方法传入的参数持有指定注解的执行；注解类型也必须是全限定类型名；
         模式
         描述
         @args (cn.javass.spring.chapter6.Secure)
         任何一个只接受一个参数的方法，且方法运行时传入的参数持有注解 cn.javass.spring.chapter6.Secure；动态切入点，类似于arg指示符；

         */
    }
}
