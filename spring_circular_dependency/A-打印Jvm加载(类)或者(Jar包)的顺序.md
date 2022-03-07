不同于class加载是jvm级行为，同样-verbose:class也是jvm参数。
但properties加载则是应用行为，能否输出则需要看对应的加载类是否输出了日志，可以考虑给对应类的日志级别调为debug级试试
jvm参数-verbose:class，可以把类加载过程打印出来

==============================================================
-XX:+TraceClassPaths     ## 按顺序输出加载的 Jar 包            ||
-verbose:class           ## 按顺序输出加载的 class 和 Jar      ||
==============================================================

```shell
java -verbose:class -jar shiro-1.0.0-SNAPSHOT.jar > 1.txt
```

```text
[Opened /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.Object from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.io.Serializable from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.Comparable from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.CharSequence from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.String from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.reflect.AnnotatedElement from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.reflect.GenericDeclaration from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.reflect.Type from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.Class from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.Cloneable from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ClassLoader from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.System from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.Throwable from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.Error from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ThreadDeath from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.Exception from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.RuntimeException from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.SecurityManager from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.security.ProtectionDomain from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.security.AccessControlContext from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.security.SecureClassLoader from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ReflectiveOperationException from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ClassNotFoundException from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.LinkageError from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.NoClassDefFoundError from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ClassCastException from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ArrayStoreException from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.VirtualMachineError from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.OutOfMemoryError from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.StackOverflowError from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.IllegalMonitorStateException from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ref.Reference from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ref.SoftReference from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ref.WeakReference from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ref.FinalReference from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
[Loaded java.lang.ref.PhantomReference from /usr/java/jdk1.8.0_171-amd64/jre/lib/rt.jar]
...
[Loaded org.springframework.core.env.EnumerablePropertySource from jar:file:/test/shiro-1.0.0-SNAPSHOT.jar!/BOOT-INF/lib/spring-core-5.0.7.RELEASE.jar!/]
[Loaded org.springframework.core.env.MapPropertySource from jar:file:/test/shiro-1.0.0-SNAPSHOT.jar!/BOOT-INF/lib/spring-core-5.0.7.RELEASE.jar!/]
[Loaded org.springframework.core.env.CommandLinePropertySource from jar:file:/test/shiro-1.0.0-SNAPSHOT.jar!/BOOT-INF/lib/spring-core-5.0.7.RELEASE.jar!/]
[Loaded org.springframework.core.env.SimpleCommandLinePropertySource from jar:file:/test/shiro-1.0.0-SNAPSHOT.jar!/BOOT-INF/lib/spring-core-5.0.7.RELEASE.jar!/]
[Loaded org.springframework.core.env.CompositePropertySource from jar:file:/test/shiro-1.0.0-SNAPSHOT.jar!/BOOT-INF/lib/spring-core-5.0.7.RELEASE.jar!/]
...
```