===============================================================<br/>
spring bean 循环依赖问题，在本地环境可以，测试环境报循环依赖问题
spring 在某些情况下是存在这样的问题：
https://github.com/spring-projects/spring-framework/issues/18879
https://github.com/spring-projects/spring-framework/issues/24325
https://stackoverflow.com/questions/29347723/why-does-spring-get-circular-dependency-issues-on-one-machine-and-not-another

解决办法：
1. 去循环依赖
2. @Lazy
3. InitializingBean 时，从 context 中获取
4. @PostConstruct 去设置 bean 依赖
   https://www.baeldung.com/circular-dependencies-in-spring
===============================================================




```java
@Service
public class AService {

    @Autowired
    BService b;

    @Async
    public void test() {
        System.out.println("123");
    }
}

@Service
public class BService {

    @Autowired
    AService a;
}
```

如上例子运行,就可以得到一个Bean循环依赖并发创建的失败错误了,如下。

```text
org.springframework.beans.factory.BeanCurrentlyInCreationException:
Error creating bean with name 'AService':
Bean with name 'AService' has been injected into other beans [BService] in its raw version as part of a circular reference,
but has eventually been wrapped. This means that said other beans do not use the final version of the bean.
This is often the result of over-eager type matching - consider using 'getBeanNamesForType' with the 'allowEagerInit' flag turned off, for example.
```

不过，你不一定能运行出来，因为如上例子还要依赖于一个事实，那就 AService 要在 BService 之前被扫描到，
而不同的jvm上，可能Spring得到的扫描顺序不一致，如果想要100%失败，则换成两个类都是构造器注入就可以了！

当出现这种错误，为什么重启以下可能就OK了，可能Spring得到的扫描顺序不一致。


Jvm加载jar包的顺序:
使用-XX:+TraceClassPaths或者在服务器上执行jinfo命令时，都能得到classpath包含的jar包；
于是我在几个服务器上用jinfo输出了java.class.path，并对比了一下发现正常服务器和服务器中，这两个jar的顺序果然是不一样的。
