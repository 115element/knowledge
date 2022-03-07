package com.example.code.lambda_new;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
