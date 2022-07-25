package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {
    static Predicate<Student> predicate = student -> student.getGradeLevel()>=3;
    public static void main(String[] args) {
        Map<String, List<String>> mapStudent = StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .filter(predicate)
                .collect(Collectors.toMap(student -> student.getName(), Student::getActivities));


        System.out.println(mapStudent);
    }
}
