package com.example.spring_circular_dependency.circle2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Description:
 *
 * The dependencies of some of the beans in the application context form a cycle:
 *
 * ┌─────┐
 * |  c defined in file [G:\WorkStation\knowledge\circle-dependency\target\classes\com\example\circledependency\circle2\C.class]
 * ↑     ↓
 * |  d defined in file [G:\WorkStation\knowledge\circle-dependency\target\classes\com\example\circledependency\circle2\D.class]
 * └─────┘
 */

@Service
public class C {

    final D d;

    public C(@Autowired D d) {
        this.d = d;
    }
}
