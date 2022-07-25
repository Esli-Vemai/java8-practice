package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollecterGroupingWithByMaxAndByMinBy {
    public static void main(String[] args) {
        findTopGpa();
        findTopGpaWithoutOptional();

    }

    public static void findTopGpa() {
        Map<Integer, Optional<Student>> studentGPA = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));

        System.out.println(studentGPA);
    }

    public static void findTopGpaWithoutOptional() {
        Map<Integer, Student> studentGPAWithoutOptional = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));

        System.out.println(studentGPAWithoutOptional);

        Map<Integer, List<Student>> studentGPAWithoutOptional2 = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(toList(), Collections::unmodifiableList)));

        System.out.println("==================================");
        System.out.println(studentGPAWithoutOptional2);
    }
}
