package com.learn.java8.functionalInterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    static BinaryOperator<Integer> binaryOperator = (int1, int2) -> int1 + int2;
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> {
            return a.compareTo(b);
        };
        System.out.println("Sum of numbers using binary operator: " + binaryOperator.apply(2, 3));
        System.out.println("Max value: " + BinaryOperator.maxBy(comparator).apply(4, 5));
        System.out.println("Min value: " + BinaryOperator.minBy(comparator).apply(4, 5));

    }
}
