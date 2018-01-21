package com.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by wangqi on 18/1/21.
 */
@Component
@Aspect
public class ParamAspect {

    @Before("execution(* com.spring5.service.SampleImp.sampleGenericMethod(*)) && args(param)")
    public void beforeSampleMethod(StringBuilder param) {
        param.append(" be processed");
    }

    @Before("execution(* com.spring5.service.SampleImp.sampleGenericCollectionMethod(*)) && args(param)")
    public void beforeSampleMethod(List<StringBuilder> param) {
        param.get(0).append("sss");
        System.out.println(param.size());
    }

    @Before("execution(* com.spring5.service.ParamsImp.manyParams(..)) && args(pp,p)")
    public void manyParams(String p, String pp) {
        System.out.println("增强"+p+"--->"+pp);
    }



}
