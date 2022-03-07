package com.example.code.stream_new;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.code.optional.Employee;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;


public class TestStreamAPI3 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );

    //3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        /**
         * 过程是这样的：
         * 先将identity作为x, 然后从流中取出一个元素作为y, 将x与y相加的和作为下一次的x
         * 然后再从集合中取出一个元素作为y, 如此循环往复，直到流结束
         */
        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }


    @Test
    public void test00() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("----------------------------------------");
        Optional<Integer> reduce = list.stream()
                .reduce((x, y) -> {                 //先将流中第一个元素作为x,再将流中第二个元素作为y,然后将x+y的和作为下一次的x
                    System.out.println("x==" + x);    //继续从流中再取一个元素，如此循环
                    System.out.println("y==" + y);    //注意：如果流中只有一个元素，那么reduce不会执行，直接返回结果
                    System.out.println("+++++");
                    return x + y;
                });
        System.out.println(reduce.get());
    }


    //需求：搜索名字中 “六” 出现的次数
    @Test
    public void test2() {
        Optional<Integer> sum = emps.stream()
                .map(Employee::getName)
                .flatMap(TestStreamAPI1::filterCharacter)
                .map((ch) -> {
                    if (ch.equals('六'))
                        return 1;
                    else
                        return 0;
                }).reduce(Integer::sum);

        System.out.println(sum.get());
    }

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test3() {
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("----------------------------------");

        HashSet<String> hs = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    @Test
    public void test4() {
        //按照什么比较最大的那个
        Optional<Double> max = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));
        System.out.println(max.get());

        //按照什么比较最小的那个
        Optional<Employee> op = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(op.get());

        //求和
        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //求平均值
        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        //求数量
        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("--------------------------------------------");

        //Statistics 统计器
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
    }

    //分组
    @Test
    public void test5() {
        Map<Employee.Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }

    //多级分组 【先按状态分组，再按年龄分组】
    @Test
    public void test6() {
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60)
                        return "老年";
                    else if (e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));

        System.out.println(map);
    }

    //分区
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

        System.out.println(map);
    }

    //
    @Test
    public void test8() {
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "----", "----"));

        System.out.println(str);
    }

    @Test
    public void test9() {
        Optional<Double> sum = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));

        System.out.println(sum.get());
    }


    @Test
    public void test10() {
        List<Employee> temperatureList = Lists.newArrayList();
        temperatureList.add(new Employee(1, "haha"));
        temperatureList.add(new Employee(2, "haha"));
        temperatureList.add(new Employee(3, "haha"));
        temperatureList.add(new Employee(4, "haha"));

        temperatureList.add(new Employee(1, "hahaasdas"));
        temperatureList.add(new Employee(2, "hahaasdas"));

        List<Employee> result = temperatureList.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(
                                        () -> new TreeSet<Employee>(Comparator.comparing(Employee::getId))
                                ),
                                ArrayList::new
                        )
                );
        result.forEach(System.out::println);

        /*
输出结果为：
Employee [id=1, name=haha, age=0, salary=0.0, status=null]
Employee [id=2, name=haha, age=0, salary=0.0, status=null]
Employee [id=3, name=haha, age=0, salary=0.0, status=null]
Employee [id=4, name=haha, age=0, salary=0.0, status=null]
因为TreeSet底层是使用TreeMap进行实现的，传入了根据getId进行比较的比较器在判断Id相同时，其比较结果为0，然后就会替换其value值，而key值是不会变化的，
又因为TreeSet是将传入的元素作为key的，所以使用TreeSet时，当比较器比较的结果相同时，不会将原来的值替换成比较后的值
         */
    }


    @Test
    public void test11() {
        List<Employee> list = Lists.newArrayList();
        list.add(new Employee(1, "haha"));
        list.add(new Employee(2, "haha"));
        list.add(new Employee(3, "haha"));
        list.add(new Employee(4, "haha"));

        Function<Employee, String> function = (emp) -> {
            return emp.getName();
        };
        List<String> collect = list.stream().collect(Collectors.mapping(function, Collectors.toList()));
        System.out.println(collect);
    }


    @Test
    public void test12() {
        Map<String, String> map1 = new HashMap();
        map1.put("1","1");
        map1.put("2","2");
        map1.put("3","3");

        Map<String, String> map2 = new HashMap();
        map2.put("4","4");
        map2.put("5","5");

        /**
         * 只需返回新值即可覆盖旧值： (old, new) -> new
         * 只需返回旧值即可保留旧值：(old, new) -> old
         * 以某种方式合并两者，例如：(old, new) -> old + new
         * 甚至删除旧值：(old, new) -> null
         */
        map1.merge("3", "3", (v1, v2) -> v1+v2);
        System.out.println(map1); //{1=1, 2=2, 3=33}
    }

}
