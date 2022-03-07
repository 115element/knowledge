package com.cloud.chang.ws;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface XStreamQName {

	public String namespaceURI() default "";

	public String localPart() default "";

	public String prefix() default "";

	public String className() default "";
}
