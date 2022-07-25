package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, String> stringPrnt = (a, b) -> {
            System.out.println(a + " and " + b);
        };
        stringPrnt.accept("Java 7", "Java 8");

        BiConsumer<Integer, Integer> multiply = (a,b) -> {
            System.out.println("Multiplication: " + a*b);
        };
        BiConsumer<Integer, Integer> division = (a,b) -> {
            System.out.println("Division: " + a/b);
        };
        System.out.println( 6 +" and " + 3);
        multiply.andThen(division).accept(6, 3);

        exampleWithStudent();
    }

    public static void exampleWithStudent() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        BiConsumer<String, List<String>> studentNameANdActivities = (a, b) -> {
            System.out.println(a + ": \n" + b);
        };
        studentList.forEach(student -> studentNameANdActivities.accept(student.getName(), student.getActivities()));
    }
}
