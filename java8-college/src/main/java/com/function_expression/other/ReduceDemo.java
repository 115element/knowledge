package com.function_expression.other;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class ReduceDemo {

    @Test
    public void b() {
        final BigDecimal bigDecimal = new BigDecimal(3);
        final BigDecimal bigDecimal1 = new BigDecimal(4);
        System.out.println(bigDecimal.divide(bigDecimal1, 2, RoundingMode.HALF_UP));
    }

    /**
     * 计算相邻差值是否达到某个值
     */
    @Test
    public void duration() {
        AtomicBoolean flag = new AtomicBoolean(false);
        BigDecimal percentage = new BigDecimal(60);
        Stream.of(new BigDecimal(1),
                new BigDecimal(6),
                new BigDecimal(3),
                new BigDecimal(7),
                new BigDecimal(5))
                .reduce((x, y) -> {
                    if (x.compareTo(y) > 0) {
                        BigDecimal divide = y.divide(x, 2, RoundingMode.HALF_UP);
                        BigDecimal falls = BigDecimal.ONE.subtract(divide);
                        System.out.println("(x,y) of falls=" + falls);
                        BigDecimal percent = percentage.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                        System.out.println("(x,y) of percent=" + percent);
                        if (falls.compareTo(percent) > -1) {
                            flag.set(true);
                        }
                    }
                    return y;
                });
        System.out.println("Result:" + flag.get());
    }


    @Test
    public void test0() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce((left, right) -> {
                    System.out.println("left--" + left);
                    System.out.println("right--" + right);
                    return left + right;
                });

        System.out.println(sum.get());
        //left--1
        //right--2
        //left--3
        //right--3
        //left--6
        //right--5
        //11
    }


    @Test
    public void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5);

        Integer sum = numbers.stream()
                .reduce(10, (left, right) -> {
                    System.out.println("left--" + left);
                    System.out.println("right--" + right);
                    return left + right;
                });

        System.out.println(sum);
        //left--10
        //right--1
        //left--11
        //right--2
        //left--13
        //right--3
        //left--16
        //right--5
        //21
    }

    @Test
    public void test2() {
        //reduce第三个参数只有并行流有用
        //而第三个参数combiner函数，则是将每个线程的执行结果当成一个新的流，然后使用第一个方法reduce(accumulator)流程进行规约。
        List<Integer> numbers = Arrays.asList(1, 3, 4);

        //串行流
        // 1*10 + 2*10 + 3*10
        Integer sum1 = numbers.stream()
                .reduce(10, (identity, val) -> {
                    System.out.println("identity--" + identity);
                    System.out.println("val--" + val);
                    return identity * val;
                }, (left, right) -> {
                    System.out.println("left--" + left);
                    System.out.println("right--" + right);
                    return left + right;
                });

        System.out.println("sum1=" + sum1); //output 120


        //并行流
        //而第三个参数combiner函数，则是将每个线程的执行结果当成一个新的流，然后使用第一个方法reduce(accumulator)流程进行规约。
        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        Integer sum2 = numbers.parallelStream()
                .reduce(10, (identity, val) -> {
                    System.out.println("identity--" + identity);
                    System.out.println("val--" + val);
                    return identity * val;
                }, (left, right) -> {
                    System.out.println("left--" + left);
                    System.out.println("right--" + right);
                    return left + right;
                });
        System.out.println("sum2=" + sum2); //output 80
    }

    @Test
    public void u111() {
        System.out.println("abcd".substring(-1));
    }


    @Test
    public void ll() {
        String luckUser = "1234567891";
        System.out.println(luckUser.substring(0, 3) + "****" + luckUser.substring(6, 10));
    }

    /**
     * NullPointerException
     * null不能和基本类型进行比较
     * <p>
     * 对于每一个Java程序员来说,null肯定是一个让人头痛的东西,连Java的发明者都承认这是一项巨大的设计失误,今天就来总结一下Java中关于null的知识.
     * <p>
     * 1.null不属于任何类型,可以被转换成任何类型,但是用instanceof永远返回false.
     * 2.null永远不能和八大基本数据类型进行赋值或比较运算等,否则不是编译出错,就是运行出错.
     * 3.null可以和字符串进行运算.
     * 4.同种类型的null,比较都返回true,null==null也返回true.
     */
    @Test
    public void ee() {
        Long x = null;
        if (5 == x) {
            System.out.println("11");
        } else {
            System.out.println("22");
        }
    }

    @Test
    public void lop() {
        System.out.println(Objects.equals(null, 0L));
    }

}
