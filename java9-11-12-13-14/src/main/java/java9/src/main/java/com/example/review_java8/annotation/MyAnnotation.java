package com.example.review_java8.annotation;//package com.review_java8.annotation;
//
//import static java.lang.annotation.ElementType.CONSTRUCTOR;
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
//import static java.lang.annotation.ElementType.METHOD;
//import static java.lang.annotation.ElementType.PARAMETER;
//import static java.lang.annotation.ElementType.TYPE;
//import static java.lang.annotation.ElementType.TYPE_USE;
//
//import java.lang.annotation.Repeatable;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE})
//@Retention(RetentionPolicy.SOURCE)
//@Repeatable(MyAnnotations.class) //JDK8支持的可重复注解
//public @interface MyAnnotation {
//	String value();
//}
