package com.stack_structure.code;

class Father {
    public static void print(String str) {
        System.out.println("father " + str);
    }
    private void show(String str) {
        System.out.println("father " + str);
    }
}
class Son extends Father {
}
public class VirtualMethodTest {
    public static void main(String[] args) {
        Son.print("coder");
        //Father fa = new Father();
        //fa.show("cooooder");
    }
}
