package com.stream.sorted;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedStudy {

    static List<Person> persons = new ArrayList<>();
    final static Person person1 = new Person(0, "1", "2");
    final static Person person2 = new Person(0, "0", "1");
    final static Person person3 = new Person(0, "1", "0");

    static {
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
    }


    //TODO 自定义比较器
    @Test
    public void s(){
        /**
         * 定义比较器类 继承Comparator接口，然后重写compare（a，b） 方法，返回的结果是int类型;
         *  0  代表 a==b
         *  1  代表 a>b
         * -1  代表 a<b
         */
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //按照年龄从大到小排序
                return o1.getId() - o2.getId();
            }
        };
        System.out.println("[Before]"+persons);
        persons.sort(comparator);
        System.out.println("[After]"+persons);
    }


    //TODO 从小到大的复杂排序(多条件排序)
    @Test
    public void study1() {
        System.out.println("[Before]" + persons);
        /**
         * 这段代码意思是：
         * 将Person先按照id从小到大排序，
         * 如果id相同，那么再按照name从小到大排序，
         * 如果name也相同，那么再按照age从小到大排序。
         */
        final List<Person> collect = persons.stream()
                .sorted(Comparator.comparing(Person::getId)
                        .thenComparing(Person::getName)
                        .thenComparing(Person::getAge))
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("[After]" + collect);
        /**
         * thenComparing方法源码解释：
         * Returns a lexicographic(词典的)-order comparator with another comparator.
         * If this Comparator considers two elements equal, i.e. compare(a, b) == 0,
         * other is used to determine the order.
         * The returned comparator is serializable if the specified comparator is also serializable；
         *
         * 返回词典顺序与另一个比较器的比较器。
         * 如果比较器认为两个元素相等，即compare(a, b) == 0，
         * other用于确定顺序。
         * 如果指定的比较器也是可序列化的，返回的比较器是可序列化的；
         */
    }


    //TODO 从大到小的复杂排序(多条件排序)
    @Test
    public void study2() {
        System.out.println("[Before]" + persons);
        /**
         * 这段代码意思是：
         * 将Person先按照id从大到小排序，
         * 如果id相同，那么再按照name从大到小排序，
         * 如果name也相同，那么再按照age从大到小排序。
         */
        final List<Person> collect = persons.stream()
                .sorted(Comparator.comparing(Person::getId, Comparator.reverseOrder())
                        .thenComparing(Person::getName, Comparator.reverseOrder())
                        .thenComparing(Person::getAge, Comparator.reverseOrder()))
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("[After]" + collect);
    }

    @Test
    public void warning(){
        //TODO 以下写法，相当于只按照年龄排序
        System.out.println("[Before]"+persons);
        final List<Person> collect = persons.stream()
                .sorted(Comparator.comparing(Person::getId))//没有意义
                .sorted(Comparator.comparing(Person::getName))//没有意义
                .sorted(Comparator.comparing(Person::getAge))//因为这里又按照了年龄排序，所以上面两个的排序是没有意义的(浪费算力)；
                .collect(Collectors.toList());
        System.out.println("[After]"+collect);
    }

}
