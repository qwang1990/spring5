package com.spring5.api;

import java.util.List;

/**
 * Created by wangqi on 18/1/21.
 */
public interface Sample<T> {
    void sampleGenericMethod(T param);
    void sampleGenericCollectionMethod(List<T> param);
}

