package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingInt;

public class CollectorsSummingAveragingIntExample {
    public static void main(String[] args) {
        System.out.println("summingInt(): " + summingIntExample());

        System.out.println("averagingIntExample(): " + averagingIntExample());

    }

    public static int summingIntExample() {
         Integer sumInt = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
         return sumInt;
    }

    public static Double averagingIntExample() {
        Double average = StudentDataBase.getAllStudents().stream()
                .collect(averagingInt(Student::getNoteBooks));

        return average;
    }
}
