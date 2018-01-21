package com.spring5;

import com.spring5.api.MessageService;
import com.spring5.api.ParamsInterface;
import com.spring5.api.Sample;
import com.spring5.api.TestThisInterface;
import com.spring5.service.MessageServiceImp;
import com.spring5.service1.MessageServiceImp1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangqi on 18/1/11.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Application {


    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

    /**
     *  MessageServiceImp messageService = (MessageServiceImp) context.getBean("message");
     *  messageService.getMessage();
     *  messageService.nonInterfaceMethod();
     *  会抛异常:com.sun.proxy.$Proxy18 cannot be cast to com.spring5.service.MessageServiceImp
     *  因为在targetMessagePoint改切点已经增强了这个接口。所以就变成代理了。
     */


        //这里虽然是MessageService类型，但是被AOP引入了TestThisInterface接口。
        MessageService messageService1 = context.getBean("message1",MessageService.class);
        System.out.println(messageService1.getMessage());
        TestThisInterface testThisInterface = (TestThisInterface) messageService1;
        testThisInterface.sayHello();


        //泛型参数
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        Sample sample = context.getBean(Sample.class);
        sample.sampleGenericMethod(sb);
        List<StringBuilder> ss = new ArrayList<StringBuilder>();
        ss.add(sb);
        sample.sampleGenericCollectionMethod(ss);

        //参数绑定
        ParamsInterface paramsInterface = context.getBean(ParamsInterface.class);
        paramsInterface.manyParams("hello", "world");



    }
}