package com.example.spring_circular_dependency.circle2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class D {

    final C c;

    public D(@Autowired C c) {
        this.c = c;
    }
}
