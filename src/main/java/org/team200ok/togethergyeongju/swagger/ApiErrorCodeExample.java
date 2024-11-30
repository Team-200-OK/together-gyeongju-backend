package org.team200ok.togethergyeongju.swagger;

import org.team200ok.togethergyeongju.config.HttpErrorCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiErrorCodeExample {
    String description() default "";
    HttpErrorCode value();
}