package com.learn.java8.functionalInterface;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> predicate = (a) -> a%2 == 0;
    static Predicate<Integer> predicate2 = (a) -> a%5 == 0;

    public static void main(String[] args) {
        System.out.println("Predicate value: " + predicate.test(5));
        predicateAndExample();
        predicateOrExample();
        predicateNegateExample();

    }

    public static void predicateAndExample() {
        System.out.println("Predicate \"And\" result: " + predicate.and(predicate2).test(10));
        System.out.println("Predicate \"And\" result: " + predicate.and(predicate2).test(9));
    }

    public static void predicateOrExample() {
        System.out.println("Predicate \"Or\" result: " + predicate.or(predicate2).test(10));
        System.out.println("Predicate \"Or\" result: " + predicate.or(predicate2).test(8));
    }

    public static void predicateNegateExample() {
        System.out.println("Predicate \"Negate\" result: " + predicate.or(predicate2).negate().test(8));
    }
}
