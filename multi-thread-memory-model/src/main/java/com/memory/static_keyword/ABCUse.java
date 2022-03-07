package com.memory.static_keyword;

//static keyword use method
// static变量只有一份，是与Class相关的
public class ABCUse {

    public static void main(String[] args) {
        //todo 获取不到值，因为是普通成员变量，每个实例都有一份
        A a1 = new A();
        A a2 = new A();
        a1.setA("AAA");
        System.out.println(a2.getA());


        //todo 可以获取到值BBB，因为是静态成员变量，只有一份，所有实例共享这一份，它只属于Class的
        B b1 = new B();
        B b2 = new B();
        b1.setB("BBB");
        System.out.println(b2.getB());
    }

}


class A {
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}

class B {
    private static String b;

    public static String getB() {
        return b;
    }

    public static void setB(String b) {
        B.b = b;
    }
}
