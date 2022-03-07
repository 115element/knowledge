package com.example.spring_circular_dependency.java_class_loading;

/**
 * (原生Java)测试成员变量和类的加载先后顺序:
 * 成员变量，是先于构造方法加载的。
 * 而且，静态的成员变量，优先于非静态成员变量加载。
 */
public class TestClassLoading {

    public static void main(String[] args) {
        ClassX classX = new ClassX();
    }
}
