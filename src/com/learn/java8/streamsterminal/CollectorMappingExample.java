package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class CollectorMappingExample {

    public static void main(String[] args) {
        List<String> studentNames = StudentDataBase.getAllStudents().stream()
                //.filter(student -> student.getName().startsWith("E"))
                .collect(mapping(Student::getName, toList()));
                //.collect(mapping(Student::getName, toSet()));

        System.out.println("List of students: " + studentNames);

        //the above example without using Collectors.mapping() method
        List<String> namesWithoutMapping = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(toList());
        System.out.println("namesWithoutMapping: " + namesWithoutMapping);

    }
}
