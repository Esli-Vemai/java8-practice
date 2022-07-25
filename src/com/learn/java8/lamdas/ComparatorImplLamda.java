package com.learn.java8.lamdas;

import java.util.Comparator;

public class ComparatorImplLamda {
    public static void main(String[] args) {
        /**
         * Using legacy way
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
                /**
                 * If o1 == o2, returns 0
                 * o1 > o2, returns 1
                 * o1 < o2, returns -1
                 */
            }
        };
        System.out.println("Result of comparision is: " + comparator.compare(3, 2));


        /**
         * Using Lamda
         */
        Comparator<Integer> comparatorLamda = (Integer a, Integer b) -> {
            return a.compareTo(b);
        };
        System.out.println("Result of comparision with Lamda is: " + comparatorLamda.compare(3, 2));

        // Or more concisely
        Comparator<Integer> comparatorLamda1 = (a, b) -> a.compareTo(b);
        System.out.println("Result of comparision with concise Lamda is: " + comparatorLamda1.compare(3,2));
    }
}
