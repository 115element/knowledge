package com.example.code.function_interface;

//创建一个名为BranchHandle的函数式接口，接口的参数为两个Runnable接口。这两个两个Runnable接口分别代表了为true或false时要进行的操作

@FunctionalInterface
public interface MyFunction4 {

    /**
     * 分支操作
     *
     * @param trueHandle  为true时要进行的操作
     * @param falseHandle 为false时要进行的操作
     */
    public void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);
}
