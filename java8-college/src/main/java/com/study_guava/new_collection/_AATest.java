package com.study_guava.new_collection;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.jupiter.api.Test;

public class _AATest {


    //guava 提供的Multiset可以具有重复的元素
    @Test
    public void _0(){
        Multiset multiset = HashMultiset.create();
        multiset.add("4",6);

        //查看指定元素出现的次数
        System.out.println(multiset.count("4"));
    }
}
