package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {
    public static void main(String[] args) {
        System.out.println("====studentActivities======");
        //System.out.println(studentActivities());
        studentActivities().forEach(System.out::println);

        System.out.println("====studentActivitiesSortedByName======");
        studentActivitiesSortedByName().forEach(System.out::println);

        System.out.println("====studentActivitiesSortedByGPA======");
        System.out.println(studentActivitiesSortedByGPA());

        System.out.println("====studentActivitiesSortedByGpaDesc======");
        System.out.println(studentActivities());
    }

    public static List<String> studentActivities() {
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Student> studentActivitiesSortedByName() {
        return StudentDataBase.getAllStudents()
                .stream()
                // sorted using the comparing() method that accepts a Function interface that will outputs the
                // input of the comparing() method
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> studentActivitiesSortedByGPA() {
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> studentActivitiesSortedByGpaDesc() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
}
