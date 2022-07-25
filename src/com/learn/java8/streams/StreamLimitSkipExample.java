package com.learn.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(6,7,8,9,10);

        Optional<Integer> sumUsingLimit = new StreamLimitSkipExample().limitExample(lists);
        if(sumUsingLimit.isPresent()) {
            System.out.println(sumUsingLimit.get());
        } else {
            System.out.println("No input");
        }

        System.out.println("====================================================");

        Optional<Integer> skipOptional = new StreamLimitSkipExample().skipExample(lists);
        if(skipOptional.isPresent()) {
            System.out.println(skipOptional.get());
        } else {
            System.out.println("No input");
        }

    }

    public Optional<Integer> limitExample(List<Integer> intergerList) {
        return intergerList.stream()
                .limit(Math.abs(intergerList.size()/2))
                .reduce((x,y) -> x+y);
    }

    public Optional<Integer> skipExample(List<Integer> integerList) {
        int length = integerList.size() / 2;
        return integerList.stream()
                .skip(length)
                .reduce((a,b) -> a+b);
    }
}
