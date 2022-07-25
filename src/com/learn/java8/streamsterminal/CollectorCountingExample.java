package com.learn.java8.streamsterminal;

import com.learn.java8.data.StudentDataBase;

import static java.util.stream.Collectors.counting;

public class CollectorCountingExample {

    public static void main(String[] args) {
        Long count = StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.7)
                .collect(counting());

        System.out.println("Collector.counting(): " + count);
    }

}
