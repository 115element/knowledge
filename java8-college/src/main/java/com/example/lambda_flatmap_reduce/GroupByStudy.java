package com.example.lambda_flatmap_reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByStudy {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 1, 6));
        students.add(new Student(2, 2, 6));
        students.add(new Student(3, 3, 9));
        students.add(new Student(4, 4, 9));

        //TODO 分组
        Map<Integer, List<Student>> collect1 = students.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(collect1);

        //TODO 多重分组，先根据类型分，再根据年龄分
        Map<Integer, Map<Integer, List<Student>>> collect2 = students.stream().collect(Collectors.groupingBy(Student::getType, Collectors.groupingBy(Student::getAge)));
        System.out.println(collect2);

        //TODO 分区 (分成两部分，一部分大于3岁，一部分小于3岁)
        Map<Boolean, List<Student>> collect3 = students.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 3));
        System.out.println(collect3);

        //TODO 规约，计算所有人总年龄
        Integer integer = students.stream().map(Student::getAge).reduce(Integer::sum).orElse(0);
        System.out.println(integer);

        //TODO 规约，计算所有人平均年龄
        Double aDouble = students.stream().mapToInt(Student::getAge).average().orElse(0);
        System.out.println(aDouble);
    }

}


class Student {
    int id;
    int type;
    int age;

    public Student(int id, int age, int type) {
        this.id = id;
        this.age = age;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}