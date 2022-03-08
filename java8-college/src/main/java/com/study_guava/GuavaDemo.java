package com.study_guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * guava一些常用的
 */

public class GuavaDemo {

    /**
     * 判断工具
     */
    @Test
    public void test() {
        Preconditions.checkNotNull(null, "userInfo不能为空");

        int projectId = 9;
        Preconditions.checkArgument(projectId > 0, "输入projectId必须大于0", projectId);
    }


    /**
     * 字符串连接器Joiner
     */
    @Test
    public void test2() {
        StringBuilder stringBuilder = new StringBuilder("哈哈,");

        //字符串连接器，以|为分隔符，同时去掉null元素
        Joiner joiner = Joiner.on("|").skipNulls();

        stringBuilder = joiner.appendTo(stringBuilder, "jim", "jack", null, "kevin");
        System.out.println(stringBuilder);
    }


    /**
     * 字符串工具Strings
     */
    @Test
    public void test3() {
        System.out.println(Strings.isNullOrEmpty("")); //true
        System.out.println(Strings.isNullOrEmpty(" ")); //false
        System.out.println(Strings.isNullOrEmpty(null)); //true
    }


    /**
     * 字符串匹配器
     */
    @Test
    public void test4() {
        String s = "hello world\r\r you are here";

        //跳过空格并把空格替换为#
        String d = CharMatcher.whitespace()
                .replaceFrom(s, "#");
        System.out.println(d);
    }


    //java自带的
    @Test
    public void _1() {
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); //true
        possible.get(); //5
    }


    //java自带的
    @Test
    public void _2() {
        System.out.println("22".equals(null));
    }

}
