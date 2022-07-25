package com.learn.java8.streamsnumeric;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamNumericAggregateExample {
    public static void main(String[] args) {
        //sum() example
        IntStream intStream = IntStream.rangeClosed(1,50);
        int sum = intStream.sum();
        System.out.println("Sum: " + sum);

        //max() example
        OptionalInt maxValue = IntStream.rangeClosed(1, 50).max();
        System.out.print("Max value: ");
        System.out.println(maxValue.isPresent() ? maxValue.getAsInt(): 0);

        //min() example
        OptionalLong minVlaue = LongStream.rangeClosed(50, 100).min();
        System.out.print("Min value: ");
        System.out.println(minVlaue.isPresent() ? minVlaue.getAsLong(): 0);

        //avg() example
        OptionalDouble avg = IntStream.rangeClosed(1, 50).asDoubleStream().average();
        System.out.print("Average: ");
        System.out.println(avg.isPresent()? avg.getAsDouble(): 0);
    }
}
