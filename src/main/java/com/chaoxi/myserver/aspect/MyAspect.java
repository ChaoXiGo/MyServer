package com.chaoxi.myserver.aspect;

import com.chaoxi.myserver.annotation.MyAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
