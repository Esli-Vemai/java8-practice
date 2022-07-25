package com.learn.java8.methodreference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {
    static Function<String, String> lamdaToUppercase = (string) ->string.toUpperCase();
    static Function<String, String> lamdaMethodReference = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(lamdaToUppercase.apply("java8"));
        System.out.println(lamdaMethodReference.apply("java8 - using method reference"));

    }
}
