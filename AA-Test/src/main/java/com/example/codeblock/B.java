package com.example.codeblock;

public class B extends A {
    static {
        System.out.println("B static{}");
    }

    public B() {
        System.out.println("BBB");
    }

    {
        System.out.println("B{}");
    }

    public static void main(String[] args) {
        B c = new B();

    }


}
