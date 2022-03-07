package com.example.spring_circular_dependency.spring_class_loading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassM {

    @Autowired
    private ClassN classN;

    public ClassM(){
        System.out.println("ClassM Construct");
    }

    /**
     * 注意：Spring的类加载时，是先执行构造方法，然后再去执行带注解的成员的初始化操作；这点正好和原生Java相反。
     * 所以：这里是先执行ClassM的构造方法，然后才去执行N的构造方法。
     */
}
