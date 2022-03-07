package com.example.spring_circular_dependency.spring_class_loading;

import org.springframework.stereotype.Component;

@Component
public class ClassN {

    public ClassN(){
        System.out.println("ClassN Construct");
    }
}
