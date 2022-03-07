package com.example.code.function_interface;


//定义一个抛出异常的形式的函数式接口，这个接口只有参数没有返回值是个消费型接口

@FunctionalInterface
public interface MyFunction3 {

    /**
     * 抛出异常消息
     * @param message
     */
    public void throwMessage(String message);

}
