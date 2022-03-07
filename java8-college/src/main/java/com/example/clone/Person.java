package com.example.clone;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -91029393040392L;

    private String name;
    private int age;
    private Son car;

    public Person(String name, int age, Son car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Son getCar() {
        return car;
    }

    public void setCar(Son car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
