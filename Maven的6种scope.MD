#「compile」
默认就是compile，什么都不配置也就是意味着compile。
compile表示被依赖项目需要参与当前项目的编译，当然后续的测试，运行周期也参与其中，是一个比较强的依赖。打包的时候通常需要包含进去。

#「test」
scope为test表示依赖项目仅仅参与测试相关的工作，包括测试代码的编译，执行。比较典型的如junit。

#「provided」
provided意味着打包的时候可以不用包进去，别的设施(Web Container)会提供。
事实上该依赖理论上可以参与编译，测试，运行等周期。
相当于compile，但是在打包阶段做了exclude的动作，也就是在打包项目时排除此jar。

#「runtime」
runtime表示被依赖项目无需参与项目的编译，不过后期的测试和运行周期需要其参与。
与compile相比，跳过编译而已，说实话在终端的项目（非开源，企业内部系统）中，和compile区别不是很大。
比较常见的如JSR×××的实现，对应的API jar是compile的，具体实现是runtime的，compile只需要知道接口就足够了。
oracle jdbc驱动架包就是一个很好的例子，一般scope为runtime。
另外runtime的依赖通常和optional搭配使用，optional为true。我可以用A实现，也可以用B实现。

#「system」
从参与度来说，也provided相同，不过被依赖项不会从maven仓库抓，而是从本地文件系统拿，一定需要配合systemPath属性使用。
```
<systemPath>${java.home}/lib/rt.jar</systemPath>
```



#「optional」
应用场景：projectA --> 依赖projectB,  projectB --> 依赖projectC时.
```xml
<dependency>
    <groupId>com.projectC</groupId>
    <artifactId>projectC</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <optional>true</optional>
</dependency>
```
当projectB的<optional>true</optional>时, 
projectA中如果没有显式的引入projectC, 则projectA不依赖projectC, 即projectA可以自己选择是否依赖projectC
>默认<optional>的值为false, 及子项目必须依赖



#「import」
注意：scope=import,只能用在dependencyManagement里面。
该属性用来解决Maven只能依赖单个项目的问题。也就是解决Maven单依赖局限性问题。
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>xxx.xxx.xxx</groupId>
            <artifactId>xxx-xxx-xxx</artifactId>
            <version>x.x.x.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

