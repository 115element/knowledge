package com.example.set_add;


import java.util.Objects;

public class A {

    private String s;

    public A(String s) {
        this.s = s;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(s, a.s);
    }
}
