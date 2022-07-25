package com.learn.java8.streamsnumeric;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamNumericStreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println("Sum: " + new StreamNumericStreamExample().sumOfNumbers(list));
    }

    public int sumOfNumbers(List<Integer> list) {
        int length = list.size();
        list.stream().forEach(System.out::println);
        list.stream().forEach(value -> System.out.println(value + ","));
        return IntStream.rangeClosed(1,6).sum();
    }
}
