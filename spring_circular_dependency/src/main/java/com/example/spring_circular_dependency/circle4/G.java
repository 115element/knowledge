package com.example.spring_circular_dependency.circle4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * 以下异常会出现：
 * <p>
 * org.springframework.beans.factory.BeanCurrentlyInCreationException:
 * Error creating bean with name 'g':
 * Bean with name 'g' has been injected into other beans [g] in its raw version as part of a circular reference,
 * but has eventually been wrapped. This means that said other beans do not use the final version of the bean.
 * This is often the result of over-eager type matching - consider using 'getBeanNamesForType' with the 'allowEagerInit' flag turned off, for example.
 * <p>
 * 如果使用@Async注解，
 * 会被 getBeanPostProcessors() 中的
 * AsyncAnnotationBeanPostProcessor 进行处理，生成一个新的代理对象，
 * 导致和原来提前暴露的Bean(只进行了初始化,属性未填充)比对,不一样,那么源码中会抛出此异常。
 */
@Service
public class G {

    @Autowired
    G g;

    @Async
    public void test() {

    }
}
