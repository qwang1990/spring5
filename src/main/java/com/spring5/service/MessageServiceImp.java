package com.spring5.service;

import com.spring5.api.MessageService;
import org.springframework.stereotype.Component;

/**
 * Created by wangqi on 18/1/21.
 */
@Component("message")
public class MessageServiceImp implements MessageService {
    public String getMessage() {
        return "hello world";
    }

    public void nonInterfaceMethod() {
        System.out.println("我不是接口方法");
    }
}
