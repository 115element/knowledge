#「compile」
默认编译依赖范围。对于编译，测试，运行三种classpath都有效。
即在编译、测试和运行的时候都要使用该依赖jar包；

#「test」
测试依赖范围。只对于测试classpath有效。
而在编译和运行项目时无法使用此类依赖，典型的是JUnit，它只用于编译测试代码和运行测试代码的时候才需要；

#「provided」
已提供依赖范围。对于编译，测试的classpath都有效，但对于运行无效。
因为由容器已经提供，例如servlet-api.jar，这个在编译和测试的时候需要用到，
但是在运行的时候，web容器已经提供了，就不需要maven帮忙引入了。

#「runtime」
运行时依赖范围，使用此依赖范围的maven依赖，对于编译测试、运行测试和运行项目的classpath有效，
但在编译主代码时无效，比如jdbc驱动实现，运行的时候才需要具体的jdbc驱动实现。

#「system」
系统依赖范围，使用system范围的依赖时必须通过systemPath元素显示的指定依赖文件的路径，
不依赖Maven仓库解析，所以可能会造成建构的不可移植（即就是在你的电脑上可能没问题，但是到别人电脑上那就说不清楚了），
有点类似provided ，注意这个system谨慎使用。
```
<systemPath>${java.home}/lib/rt.jar</systemPath>
```

#「import」
仅pom在本节中的类型依赖项上支持此作用域。它指示依赖关系将被指定的pom部分中的有效依赖关系列表替换。
由于已替换它们，因此范围内的依赖项import实际上不会参与限制依赖项的可传递性，在springboot和springcloud中用到的比较多。



#「optional」
optional是maven依赖jar时的一个选项,表示该依赖是可选的.不会被依赖传递。
```xml
<dependency>
  <groupId>group</groupId>
  <artifactId>artifact-test</artifactId>
  <version>2.0</version>
  <!-- 该依赖不传递 -->
  <optional>true</optional>
</dependency>
```
```
现开发了一个类似Hibernate的框架，叫Summer吧，致敬下Spring，提供了多种数据库方言的支持:mysql/oracle/db2/postgresql...
每种数据库支持也独立了一个module，Summer的依赖中配置了每种数据库的支持包：summer-mysql-support/summer-oracle-support...
但是实际引用此框架/依赖时，并不需要所有数据库方言的支持。此时可以把数据库的支持包都配置为可选的<optional>true</optional>。
引用此框架时，只需按需引入自己需要的方言支持包即可，避免了冗余繁杂的依赖，也降低了jar包冲突的风险。
```
