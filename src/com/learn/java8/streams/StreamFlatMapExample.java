package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static void main(String[] args) {
        /**
         * flatMap() operation is similar to map() but use in the context where one element in the stream
         * represents multiple elements. Eg: Stream<List>, etc.
         */
        System.out.println("returnStudentActivities: " + returnStudentActivities());
    }

    public static List<String> returnStudentActivities() {
        return StudentDataBase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                //.flatMap(list -> list.stream())
                //.distinct()
                .collect(Collectors.toList()); // List<String>

    }
}
