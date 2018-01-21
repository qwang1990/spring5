package com.spring5.service;

import com.spring5.api.Sample;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangqi on 18/1/21.
 */
@Component
public class SampleImp implements Sample<StringBuilder> {


    public void sampleGenericMethod(StringBuilder param) {
        System.out.println(param.toString());
    }

    public void sampleGenericCollectionMethod(List<StringBuilder> param) {
        param.stream().forEach(s -> {
            System.out.println(s.toString());
        });

    }

}
