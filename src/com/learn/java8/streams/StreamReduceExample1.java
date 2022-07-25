package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7);
        System.out.println("sum of grade is: " + sumOfNumbersWithReduce(list));
        Optional<Integer> optional = sumWithoutIdentity(list);
        if(optional.isPresent()) {
            System.out.println("Optional value: " + optional.get());
        }

    }

    public static int sumOfNumbersWithReduce(List<Integer> list) {
        return list.stream()
                .reduce(1, (a,b) -> (a*b));
    }

    public static Optional<Integer> sumWithoutIdentity(List<Integer> list) {
            return list.stream()
                    .reduce((a,b) -> a*b);
    }

}