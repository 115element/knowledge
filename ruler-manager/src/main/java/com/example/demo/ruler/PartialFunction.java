package com.example.demo.ruler;

import java.util.function.Function;

public interface PartialFunction<T, R> extends Function<T, R> {

    boolean isDefinedAt(T t);

}