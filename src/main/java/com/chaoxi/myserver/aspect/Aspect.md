# AOP

> 通过注解代替重复代码

## 1`依赖

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

## 2`注解

> com.chaoxi.myserver.annotation.MyAnnotation

```java

@Target(ElementType.METHOD) // 元注解,作用在方法
@Retention(RetentionPolicy.RUNTIME) // 运行时使用
@Documented // 元注解,该注解将被包含在javadoc中
public @interface MyAnnotation {
    /**
     * 接收注解中传入的value, 默认""
     */
    String value() default "";
}
```

## 3`切面对象

> com.chaoxi.myserver.aspect.MyAspect

```java
@Aspect
@Component
public class MyAspect {

    // 搜索哪些方法有 MyAnnotation 注解
    @Pointcut("@annotation(com.chaoxi.myserver.annotation.MyAnnotation)")
    public void myPointCut(){}

    /**
     * 关联 myPointCut() 方法
     * 添加想做的内容
     * @param point 连接点对象
     * @return 连接对象方法的返回值
     */
    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        // 连接点对象的方法名
        String pointMethodName = point.getSignature().getName();
        // 获取注解标记的方法
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 通过方法获取注解
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        String value = "";
        if (myAnnotation != null){
            // 获取注解中value
            value = myAnnotation.value();
        }
        // 连接点对象的返回值
        Object proceed = point.proceed();
        System.out.println("pointMethodName = " + pointMethodName +
                ",\nproceed = " + proceed +
                ",\nannotation info = " + value);
        return point.proceed();
    }
}
```

## 4`测试
>com.chaoxi.myserver.controller.AOPTestController

```java
@MyAnnotation("自定义注解")
@RequestMapping("/test")
public R testAPI() {
    User user = new User();
    user.setId(12);
    user.setUsername("chaoxi");
    user.setPassword("123");
    return R.success(user);
}
```