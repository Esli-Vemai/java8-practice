package com.learn.java8.functionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = (string -> string.concat(" using unary operator"));
        System.out.println(unaryOperator.apply("Java8"));
    }
}
