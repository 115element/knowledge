package com.example.stringinterview;

public class StringA {

    public static void main(String[] args) {

        String a = "a";
        String b = "b";

        String c = a+b; //查看字节码是创建的StringBuilder

        String d = "ab";

        System.out.println(c == d); // false


//        StringBuilder的toString()方法，是new了一个String
//        @Override
//        public String toString() {
//            // Create a copy, don't share the array
//            return new String(value, 0, count);
//        }
    }


//
//    String s = new String("abc")创建了几个String对象?
//    2个.一个是字符串字面常数,在字符串常量池中;另一个是new出来的字符串对象,在堆中.
//

//    请问s1==s3是true还是false，s1==s4是false还是true?s1==s5呢？
//    String s1 = "abc";
//    String s2 = "a";
//    String s3 = s2 + "bc";
//    String s4 = "a" + "bc";
//    String s5 = s3.intern();
//    s1==s3返回false,s1==s4返回true,s1==s5返回true.
//
//    “abc"这个字符串常量值会直接方法字符串常量池中,s1是对其的引用.由于s2是个变量,编译器在编译期间无法确定该变量后续会不会改," +
//            "因此无法直接将s3的值在编译器计算出来,因此s3是堆中"abc"的引用.因此s1!=s3.对于s4而言,其赋值号右边是常量表达式," +
//            "因此可以在编译阶段直接被优化为"abc”,由于"abc"已经在字符串常量池中存在,
//    因此s4是对其的引用,此时也就意味s1和s4引用了常量池中的同一个"abc".
//    所以s1==s4.String中的intern()会首先从字符串常量池中检索是否已经存在字面值为"abc"的对象,如果不存在则先将其添加到字符串常量池中,
//    否则直接返回已存在字符串常量的引用.此处由于"abc"已经存在字符串常量池中了,因此s5和s1引用的是同一个字符串常量.
//————————————————
}
