Spring默认使用三级缓存解决循环依赖问题。特殊情况下会导致循环依赖失效。 

#比如以下两种情况：
- 1.互相循环依赖使用构造器注入。 
- 2.通过类似 @Async 注解在对象初始化时期被生成代理对象替换原对象原因。



#一般情况的循环依赖，Spring使用三级缓存解决。
```text
singletonObjects：     用于存放完全初始化好的 bean，从该缓存中取出的 bean 可以直接使用
earlySingletonObjects：提前曝光的单例对象的cache，存放原始的 bean 对象（尚未填充属性），用于解决循环依赖
singletonFactories：   单例对象工厂的cache，存放 bean 工厂对象，用于解决循环依赖
```