package com.example.io_vavr_lambda;

import io.vavr.*;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import io.vavr.control.Try;

import static io.vavr.API.*;
import static io.vavr.Predicates.isIn;
import static org.junit.Assert.*;

public class TestTest {


    //字典和元祖都是容器结构 。说白了 就是可以装东西（数据）的两个瓶子 而字典可变 元祖不可变。
    // 1.元组支持遍历（for while）
    // 2.元组是不可变类型，不支持增删改，只能查询
    // 3.元组存在的价值、意义：保证数据安全
    public static void main(String[] args) {
        Tuple3<Integer, String, Object> mc = Tuple(1, "mc", new Object());
        Match.Case<Integer, Integer> aCase = Case($(1), t -> t + 1);

        Try<Integer> result = Try.of(() -> 1 / 0);
        boolean failure = result.isFailure();
        if (!failure) {
            Integer integer = result.get();
            System.out.println(integer);
        }
        System.out.println(failure);

        int i = List.of(1, 2, 3, 4).sum().intValue();


        String out = Match(1).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(3), "three"),
                Case($(4), "four"),
                Case($(), "?")
        );
        System.out.println(out);


    }


    public void s() {
        String arg = "123";
        Match(arg).of(
                Case($(isIn("-h", "--help")), o -> run(this::displayHelp)),
                Case($(isIn("-v", "--version")), o -> run(this::displayVersion)),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException(arg);
                }))
        );
    }

    private void displayVersion() {
    }


    private void displayHelp() {
    }


    public void lazy() {
        Lazy<Double> lazy = Lazy.of(Math::random);
        assertFalse(lazy.isEvaluated());

        double val1 = lazy.get();
        assertTrue(lazy.isEvaluated());

        double val2 = lazy.get();
        assertEquals(val1, val2, 0.1);
    }

    public void s1() {
        Option<Object> noneOption = Option.of(null);
        Option<String> someOption = Option.of("val");
        System.out.println(noneOption.toString());
        System.out.println(someOption.toString());
    }

    public void function5() {
        Function5<String, String, String, String, String, String> concat =
                (a, b, c, d, e) -> a + b + c + d + e;

        String finalString = concat.apply(
                "Hello ", "world", "! ", "Learn ", "Vavr");

        assertEquals("Hello world! Learn Vavr", finalString);
    }

    public void s2() {
        Function2<Integer, Integer, Integer> sum = Function2.of(this::sum);
        Integer apply = sum.apply(5, 6);
    }

    public int sum(int a, int b) {
        return a + b;
    }



    public void zip() {
        List<Tuple2<Integer, String>> tuple2s = Stream.ofAll(1, 2, 3).zip(List.of("a", "b", "c")).toList();
        tuple2s.forEach(tuple -> {
                    System.out.println(tuple._1);
                    System.out.println(tuple._2);
                }
        );
    }

}
