package com.example.spring_circular_dependency.circle1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AService {

    @Autowired
    BService b;

    /**
     * org.springframework.beans.factory.BeanCurrentlyInCreationException:
     * Error creating bean with name 'AService':
     * Bean with name 'AService' has been injected into other beans [BService] in its raw version as part of a circular reference,
     * but has eventually been wrapped. This means that said other beans do not use the final version of the bean.
     * This is often the result of over-eager type matching - consider using 'getBeanNamesForType' with the 'allowEagerInit' flag turned off, for example.
     *
     * 【将这个异步方法转移至BService中，并将本类的这个方法删除，那么不会导致上面错误】
     */
    @Async
    public void test() {
        System.out.println("123");
    }
}
