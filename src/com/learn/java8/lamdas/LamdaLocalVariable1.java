package com.learn.java8.lamdas;

import java.util.function.Consumer;

public class LamdaLocalVariable1 {
    int i1 = 3;
    public static void main(String[] args) {
        int i = 1;
        //Not allowed, coz we cannot use the same name of a local variable in a Lamda expression
        //But no such issue with instance variable name
        //Consumer<Integer> consumer = (i) -> System.out.println(i);
        Consumer<Integer> consumer = (i1) -> System.out.println(i1);

        consumer.accept(2);
    }
}
