package com.example;

public class DivideJava {
    public static void main(String[] args) {
        //java和C一样，这个 /  符号取小数点前的整数
        //错了，计算当中 int / int 还是int类型。所以 35/4 =8; 8%3=2.
        System.out.println(35/4%3);
        String[] split1 = "[[[[1]2[[".split("\\[");

        String[] split2 = "[[[[1]2[[".split("\\[",3); //第二个参数limit，指定切割的索引界限位置

        System.out.println("空串");
    }
}
