package com.learn.java8.streamsnumeric;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

    public static List<Integer> mapToObj(){

        return IntStream.rangeClosed(1,5)
                //.map((i) -> {
                  //  return new Integer(i);
                //}) // can use Method reference as below
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    public static long mapToLong(){

        return IntStream.rangeClosed(1,5) // intstream
                //i is passed from the intstream
                .mapToLong((i)->i) // convert intstream to longStream
                .sum();
    }

    public static double mapToDouble(){

        return IntStream.rangeClosed(1,5) // intstream
                //i is passed from the intstream
                .mapToDouble((i)->i) // convert intstream to DoubleStream
                .sum();
    }

    public static void main(String[] args) {

        System.out.println("mapToObj : " + mapToObj());

        System.out.println("mapToLong : " + mapToLong());

        System.out.println("mapToDouble : " + mapToDouble());
    }
}
