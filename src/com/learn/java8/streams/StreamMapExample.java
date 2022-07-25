package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        /**
         * The Stream map() operation is used to convert from one type of data to another type.
         * It is not at all similar to Map interface in Collections API
         */

        System.out.println(returnStudentNameList());
        System.out.println(returnStudentNameAsSet());
    }

    public static List<String> returnStudentNameList() {
        return StudentDataBase.getAllStudents().stream() // Returns Stream<Student>
                //input as Student -> output as Student name (i.e., String)
                .map(student -> student.getName()) //returns Stream<String>
                //.map(Student::getName)  // >> can also use method reference like this
                .map(String::toUpperCase)
                .collect(Collectors.toList()); //returns List<String>
    }

    public static Set<String> returnStudentNameAsSet() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toSet());
    }
}
