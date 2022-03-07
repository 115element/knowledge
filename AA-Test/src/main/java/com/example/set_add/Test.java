package com.example.set_add;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        A a1 = new A("x");
        A a2 = new A("y");
        A a3 = new A("z");

        /**
         * 因为当我们向Set集合加入数据时，要加入的数据会和集合里的数据比较;
         * 会先比较hashCode()的值，如果不同那么jvm就会认为这是两个不同的数据，就会直接加入，
         * 而如果hashCode()的值相同，jvm会调用equals()来比较，如果相同就认为是一个数据，否则 就是两个数据。
         * （当hashCode()的值不同是就不会继续调用equals()了）；
         * [以上说法可以通过debug查看确实如此]
         */
        Set<A> set = new HashSet<>();
        set.add(a1);
        set.add(a2);
        set.add(a3);

        System.out.println(set.size());
    }
}
