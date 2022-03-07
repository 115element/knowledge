package com.example.codeblock;

public class A {
    static {
        System.out.println("A static{}");
    }

    public A() {
        System.out.println("AAA");
    }

    {
        System.out.println("A{}");
    }
}
