package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class CollectorJoiningExample {
    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();
        System.out.println("Joining: " + joiningExample1(students));
        System.out.println("Joining: " + joiningExample2(students));
        System.out.println("Joining: " + joiningExample3(students));
    }

    public static String joiningExample1(List<Student> list) {
        return list.stream()
                .map(Student::getName)
                .collect(joining());
                // .collect(Collectors.joining());
    }

    public static String joiningExample2(List<Student> list) {
        return list.stream()
                .map(Student::getName)
                .collect(joining(", "));
        // .collect(Collectors.joining());
    }

    public static String joiningExample3(List<Student> list) {
        return list.stream()
                .map(Student::getName)
                .collect(Collectors.joining(" - ", "(", ")"));
        // .collect(Collectors.joining());
    }

}
