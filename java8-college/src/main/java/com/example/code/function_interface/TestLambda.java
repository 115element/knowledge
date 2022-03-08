package com.example.code.function_interface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.code.lambda_new.Employee;
import org.junit.jupiter.api.Test;


public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //先按年龄降序，年龄相等，再按姓名升序
    @Test
    public void test1() {
        emps.sort((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void test2() {
        String trimStr = strHandler("\t\t\t 我尚硅谷威武   ", (str) -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("abcdef", (str) -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("我尚硅谷威武", (str) -> str.substring(2, 5));
        System.out.println(newStr);
    }

    //需求：用于处理字符串
    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    @Test
    public void test3() {
        op(100L, 200L, (x, y) -> x + y);

        op(100L, 200L, (x, y) -> x * y);
    }

    //需求：对于两个 Long 型数据进行处理
    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }


    public static MyFunction3 isTrue(boolean b) {
        return (err) -> {
            if (b) {
                throw new RuntimeException(err);
            }
        };
    }

    @Test
    public void isTrue() {
        isTrue(false).throwMessage("爬出");
    }


    public static MyFunction4 isTrueOrFalse(boolean b) {
        return (trueHandle, falseHandle) -> {
            if (b) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }


    @Test
    public void isTrueOrFalse() {
        isTrueOrFalse(false).trueOrFalseHandle(
                () -> {
                    System.out.println("true 俺要开始秀了");
                }, () -> {
                    System.out.println("false 秀不动了，快跑");
                }
        );

        isTrueOrFalse(true).trueOrFalseHandle(
                () -> {
                    System.out.println("true 俺要开始秀了");
                }, () -> {
                    System.out.println("false 秀不动了，快跑");
                }
        );
    }


    public static MyFunction5<?> isBlankOrNoBlank(String str) {
        return (consumer, runnable) -> {
            if (str == null || str.length() == 0) {
                runnable.run();
            } else {
                consumer.accept(str);
            }
        };
    }

    @Test
    public void isBlankOrNoBlank() {
        isBlankOrNoBlank("hello").presentOrElseHandle(System.out::println, () -> {
            System.out.println("空字符串");
        });

        isBlankOrNoBlank("").presentOrElseHandle(System.out::println, () -> {
            System.out.println("空字符串");
        });

        isBlankOrNoBlank("   ").presentOrElseHandle(System.out::println, () -> {
            System.out.println("空字符串");
        });
    }

    @Test
    public void my6() {
        MyFunction6 myFunction6 = message -> {
            System.out.println("hel" + message);
        };

        myFunction6.sayMessage("dll");
    }
}
