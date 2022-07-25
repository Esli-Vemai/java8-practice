package com.learn.java8.streamsnumeric;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxing {

    public static void main(String[] args) {
        List<Integer> boxing = boxing();
        System.out.println("boxing(): " + boxing);

        System.out.println("unboxing(): " + unBoxing(boxing));

    }

    /**
     *
     * @return primivite to wrapper value
     */
    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1,10) // IntStream of 10 elements
                // int
                .boxed() //Integer
                .collect(Collectors.toList()); // List<Integer>
    }

    /**
     *
     * @param integers
     * @return Wrapper to primitive value
     */
    public static int unBoxing(List<Integer> integers) {
        return integers.stream() //Stream<Integer>
                //Wrapper Integer value
                .mapToInt(Integer::intValue) // IntStream (intValue of wrapper class)
                .sum(); //int
    }
}
