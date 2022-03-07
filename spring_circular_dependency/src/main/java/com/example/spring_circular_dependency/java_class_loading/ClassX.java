package com.example.spring_circular_dependency.java_class_loading;


//(1) 在一个不存在继承的类中：初始化static变量,执行static初始化快 --> 初始化普通成员变量(如果有赋值语句),执行普通初始化块 --> 构造方法
//(2)在一个存在继承的类中：初始化父类static成员变量,运行父类static初始化块 --> 初始化子类static成员变量,运行子类static初始化块 --> 初始化父类实例成员变量(如果有赋值语句),执行父类普通初始化块 --> 父类构造方法-->初始化子类实例成员变量(如果有赋值语句)及普通初始化块 --> 子类构造方法。

public class ClassX {

    //成员变量加载之后，才会执行构造方法
    private final ClassY classY = new ClassY(); //初始化顺序②

    private final ClassZ classZ1 = new ClassZ(); //初始化顺序③

    private static final ClassZ classZ2 = new ClassZ(); //初始化顺序①


    public ClassX(){
        System.out.println("ClassX Construct"); //初始化顺序④
    }

}
