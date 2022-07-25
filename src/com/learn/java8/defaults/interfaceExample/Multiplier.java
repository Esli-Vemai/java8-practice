package com.learn.java8.defaults.interfaceExample;

import java.util.List;

public interface Multiplier {
    int multiply(List<Integer> list);

    default int size(List<Integer> list) {
        return list.size();
    }

    static boolean isEmpty(List<Integer> list) {
        //return list.isEmpty();
        return list!=null && list.size()==0;
    }
}
