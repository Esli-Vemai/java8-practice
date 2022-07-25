package com.learn.java8.defaults.interfaceExample;

import java.util.List;

public class MultiplierImpl implements Multiplier {
    @Override
    public int multiply(List<Integer> list) {
        return list.stream().reduce((x,y) -> x*y).get();
        //return list.stream().reduce(1, (x,y) -> x*y);
    }

    @Override
    public int size(List<Integer> list) {
        System.out.println("Inside MultiplierImpl size(): ");
        return list.size();
    }
}
