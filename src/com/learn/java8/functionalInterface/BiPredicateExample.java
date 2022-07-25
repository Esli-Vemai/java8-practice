package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateExample {

    BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;
    Consumer<Student> studentConsumer = (student -> {
        if (biPredicate.test(student.getGradeLevel(), student.getGpa()))
            System.out.println("Name: " + student.getName() + "\nActivities: " + student.getActivities());
    });

    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();
        printNameAndActivities(students);
    }

    public static void printNameAndActivities(List<Student> students) {
        students.forEach(new BiPredicateExample().studentConsumer);
    }
}
