package com.learn.java8.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream_OfIterateGenerateExamples {
    public static void main(String[] args) {
        OfGenerateIterateExample();
    }

    public static void OfGenerateIterateExample() {
        Stream<String> stringStream = Stream.of("Matthew","Mark", "Luke","John");
        stringStream.forEach(System.out::println);

        Stream.iterate(1, x->x*2)
                // need to limit here because iterate() returns an infinite stream
                .limit(6)
                .forEach(System.out::println);

        Supplier<Integer> randomSupplier = new Random()::nextInt;
        Stream.generate(randomSupplier)
                .limit(4)
                .forEach(System.out::println);
    }
}
