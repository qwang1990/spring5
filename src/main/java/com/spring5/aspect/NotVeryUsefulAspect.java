package com.spring5.aspect;

import com.spring5.api.TestThisInterface;
import com.spring5.service.TestThisImp;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by wangqi on 18/1/12.
 * 在本例子中，首先使用的切面的Introductions功能，让每个com.spring5.service1下的对象都实现了TestThisInterface接口
 * 接着又声明了3个切面
 * 1.thisPointcut 在Spring AOP对象实现了TestThisInterface接口时会调用。
 * 2.targetTestThisPoint 在被代理对象实现了TestThisInterface接口时会调用。
 * 3.targetMessagePoint 在被代理对象实现了MessageService接口时被调用。
 */
@Aspect
@Component
public class NotVeryUsefulAspect {

    @DeclareParents(value="com.spring5.service1.*+", defaultImpl=TestThisImp.class)
    public static TestThisInterface mixin;


    @Pointcut("this(com.spring5.api.TestThisInterface)")
    private void thisPointcut() {}

    @Pointcut("target(com.spring5.api.TestThisInterface)")
    private void targetTestThisPoint() {}

    @Pointcut("target(com.spring5.api.MessageService)")
    private void targetMessagePoint() {}


    @Before("com.spring5.aspect.NotVeryUsefulAspect.thisPointcut()")
    public void beforeThis() {
        System.out.println("Test ThisInterface before");
    }

    @Before("com.spring5.aspect.NotVeryUsefulAspect.targetTestThisPoint()")
    public void beforeTarget() {
        System.out.println("Test target service");
    }

    @Before("com.spring5.aspect.NotVeryUsefulAspect.targetMessagePoint()")
    public void beforeMessageTarget() {
        System.out.println("target message service");
    }




}
