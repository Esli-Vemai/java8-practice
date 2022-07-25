package com.learn.java8.lamdas;

import java.util.function.Consumer;

public class LamdaLocalVariable2 {
    //static int value = 4;
    public static void main(String[] args) {
        int value = 4;
        Consumer<Integer> consumer = (lamdaVal) -> {
            //Not allowed, coz local variable used in Lamda exp should be final or effectively final.
            //i.e., we cannot reassign value to local variables, no such issues with instance variable.
            //value++;
            System.out.println(lamdaVal + value);
        };
        //Even this is not allowed though it is outside lamda block, coz we are trying to modify the local variable.
        //value = value + 1;

        consumer.accept(3);
    }
}
