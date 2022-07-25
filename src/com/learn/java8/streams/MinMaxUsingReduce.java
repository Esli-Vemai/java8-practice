package com.learn.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxUsingReduce {

    /**
     * Always use Optional whenever calculating min and max using reduce()
     */

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(4,6,2,7,3,9);
        List<Integer> emptyList = new ArrayList<>();
        System.out.println("Max value without Optional: " + returnMax(numberList));

        Optional<Integer> optionalMax = returnMaxUsingOptional(emptyList);
        if (optionalMax.isPresent()) {
            System.out.println("Max with Optional: " + optionalMax.get());
        } else{
            System.out.println("Either the list is empty or no max value found");
        }

        Optional<Integer> minOptional = returnMinUsingOptional(numberList);
        System.out.println("minOptional: " + minOptional);
        if (minOptional.isPresent()) {
            System.out.println("Min value using Optional: " + minOptional.get());
        } else {
            System.out.println("No input found");
        }

    }

    public static int returnMax(List<Integer> list) {
        return list.stream().
                // x =>> holds the max value (i.e., the result of the computation) for each element of the iteration
                // y =>> holds the variable value
                        // 4 = y, x=0, default value
                        // 6=y, x=4
                        //2=y, x=6,
                        //7=y, x=6
                        // etc...
                reduce(0,(x,y) -> x > y ? x:y);
        // this method implementation is not ideal because if the list is empty, the max value returned will
        // be the default value, in this case 0.
    }

    public static Optional<Integer> returnMaxUsingOptional(List<Integer> list) {
        return list.stream().reduce((x,y) -> x > y ? x:y);
    }

    public static Optional<Integer> returnMinUsingOptional(List<Integer> list) {
        return list.stream()
                .reduce((x,y) -> x<y ? x: y);
    }
}
