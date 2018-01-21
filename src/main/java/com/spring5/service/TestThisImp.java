package com.spring5.service;

import com.spring5.api.TestThisInterface;

/**
 * Created by wangqi on 18/1/21.
 */
public class TestThisImp implements TestThisInterface {

    public void sayHello() {
        System.out.println("test this impl");
    }
}
