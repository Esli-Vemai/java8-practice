package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class CollectorGroupingByPartitioningByExample {
    public static void main(String[] args) {
        //partitionBy1();
        partitioningBy2();
    }

    public static void partitionBy1() {
        Predicate<Student> p = student -> student.getGpa()>=3.9;
        Map<Boolean, List<Student>> studentWithGPA = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(p, toList()));
        //System.out.println(studentWithGPA);

        studentWithGPA.keySet().forEach(k -> System.out.println("Gpa > 3.9? " + k +
                "\nStudent List" + studentWithGPA.get(k)));

    }

    public static void partitioningBy2() {
        Predicate<Student> p = student -> student.getGpa()>=3.9;
        Map<Boolean, List<Student>> studentWithGPA = StudentDataBase.getAllStudents().stream()
                .collect(partitioningBy(p));
        //System.out.println(studentWithGPA);

        studentWithGPA.keySet().forEach(k -> System.out.println("Gpa > 3.9? " + k +
                "\nStudent List" + studentWithGPA.get(k)));
    }
}
