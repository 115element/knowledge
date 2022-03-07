package com.example.spring_circular_dependency.circle3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 属性注入、Set注入、不会产生循环依赖错误
 */
@Service
public class E {

    F f;

    public F getF() {
        return f;
    }

    @Autowired
    public void setF(F f) {
        this.f = f;
    }
}
