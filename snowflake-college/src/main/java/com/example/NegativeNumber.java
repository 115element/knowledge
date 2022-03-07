package com.example;


/**
 * 一、符号位
 * 符号位为每个字节的最高位。最高位1为负数，0为正数。
 * 负数在内存中是以补码的方式存储的。
 *
 * 二、负数的计算(例如-8的计算)
 * 计算方式：原码->反码->补码
 * 原码（负数符号位为1）：10001000
 * 反码（符号位不变，数值位分别“按位取反”）：11110111
 * 补码（反码的末位加1）：11111000
 * 因此-8在8位机中用11111000表示。
 */
public class NegativeNumber {
    public static void main(String[] args) {
        //负数的二进制
        System.out.println(Long.toBinaryString(-1));

        //负数的移位运算
        String s = Long.toBinaryString(-1L << 5);
        System.out.println(s);

        //异或运算 相同为0，不同为1
        String s1 = Long.toBinaryString(-1L ^ (-1L << 5));
        //1110 0000
        //1111 1111
        System.out.println(s1);//11111

        //异或运算 相同为0，不同为1
        String s2 = Long.toBinaryString(-1L ^ (-1L << 12));
        System.out.println(s2);//111111111111

        System.out.println(4096&4095);
    }
}
