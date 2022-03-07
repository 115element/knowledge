package com.example.spring_circular_dependency.circle3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class F {

    E e;

    public E getE() {
        return e;
    }

    @Autowired
    public void setE(E e) {
        this.e = e;
    }
}
