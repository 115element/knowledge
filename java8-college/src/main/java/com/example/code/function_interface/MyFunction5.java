package com.example.code.function_interface;

//空值与非空值分支处理

import java.util.function.Consumer;

@FunctionalInterface
public interface MyFunction5<T extends Object> {

    /**
     * 值不为空时执行消费操作
     * 值为空时执行其他的操作
     *
     * @param consumer    值不为空时，执行的消费操作
     * @param runnable 值为空时，执行的操作
     * @return void
     **/
    public void presentOrElseHandle(Consumer<? super T> consumer, Runnable runnable);
}
