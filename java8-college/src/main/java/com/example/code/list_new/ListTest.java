package com.example.code.list_new;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {


    @Test
    public void test1() {
        List<String> list1 = new ArrayList<String>();
        list1.add("g");
        list1.add("s");
        list1.add("a");
        list1.add("f");
        List<String> list2 = new ArrayList<String>();
        list2.add("g");
        list2.add("c");
        list2.add("b");
        list2.add("a");
        list1.retainAll(list2); //求交集
        System.out.print(list1);//[g, a]
    }


    @Test
    public void test2() {
        List<String> list1 = new ArrayList<String>();
        list1.add("g");
        list1.add("s");
        list1.add("a");
        list1.add("f");
        list1.spliterator().forEachRemaining(
                x -> System.out.println(x)
        );

        //如果在进入此方法时不存在剩余元素，则为false ，否则为true
        boolean b = list1.spliterator().tryAdvance(
                x -> System.out.println(x)
        );
        System.out.println(b);
    }


    @Test
    public void test3() {
        List<String> list1 = new ArrayList<>();
        list1.add("g");
        list1.add("s");
        list1.add("a");
        list1.add("f");
        //对所有元素进行相同的操作
        list1.replaceAll(x -> x + "1");
        System.out.println(list1);
    }
}
