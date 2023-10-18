package com.chaoxi.myserver.annotation;

import java.lang.annotation.*;


@Target(ElementType.METHOD) // 元注解,作用在方法
@Retention(RetentionPolicy.RUNTIME) // 运行时使用
@Documented // 元注解,该注解将被包含在javadoc中
// @Inherited // 可被子类继承注解的元注解
public @interface MyAnnotation {
    /**
     * 接收注解中传入的value, 默认""
     */
    String value() default "";
}
