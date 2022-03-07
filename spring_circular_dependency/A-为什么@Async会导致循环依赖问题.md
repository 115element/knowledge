###网上的解释
# https://blog.csdn.net/f641385712/article/details/92797058
# https://segmentfault.com/a/1190000021217176

为什么使用@Async会导致循环依赖处理失效?
// 其实当我们使用Spring的时候，默认是会解决循环依赖，但当使用了@Async注解方法后，处理循环依赖就失效了。
```java
@Component
public class A {
	@Autowired
	private B b;
	@Async
	@Override
	public void testA() {
	}
}
```

```java
@Component
public class ClassB {
	@Autowired
	private A a;
	@Override
	public void testB() {
		a.testA();
	}
}
```

// 如果要知道底层的前因后果，需要去分析源码，这里我用别人总结的话简单说一下：
//
// 	1.context.getBean(A)开始创建A，A实例化完成后给A的依赖属性b开始赋值
// 	2.context.getBean(B)开始创建B，B实例化完成后给B的依赖属性a开始赋值
// 	3.重点：此时因为A支持循环依赖，所以会执行A的getEarlyBeanReference方法得到它的早期引用。而执行getEarlyBeanReference()的时候因为@Async根本还没执行，所以最终返回的仍旧是原始对象的地址
// 	4.B完成初始化、完成属性的赋值，此时属性field持有的是Bean A原始类型的引用
// 	5.完成了A的属性的赋值（此时已持有B的实例的引用），继续执行初始化方法initializeBean(...)，在此处会解析@Aysnc注解，从而生成一个代理对象，所以最终exposedObject是一个代理对象（而非原始对象）最终加入到容器里
// 	6.尴尬场面出现了：B引用的属性A是个原始对象，而此处准备return的实例A竟然是个代理对象，也就是说B引用的并非是最终对象（不是最终放进容器里的对象）
// 	7.执行自检程序：由于allowRawInjectionDespiteWrapping默认值是false，表示不允许上面不一致的情况发生，so最终就抛错了


#看上网上的两篇文章
