package com.spring5.service;

import com.spring5.api.ParamsInterface;
import org.springframework.stereotype.Component;

/**
 * Created by wangqi on 18/1/21.
 */
@Component
public class ParamsImp implements ParamsInterface {

    @Override
    public void manyParams(String p1, String p2) {
        System.out.println(p1+"<--->"+p2);
    }
}
