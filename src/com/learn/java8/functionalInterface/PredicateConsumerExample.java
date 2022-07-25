package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerExample {
    Predicate<Student> predicate1 = (student -> student.getGpa() >= 3.9);
    Predicate<Student> predicate2  = student -> student.getGradeLevel() >= 3;
    BiConsumer<String, List<String>> nameAndActivities = (name, activities) -> {
        System.out.println("Student Name: " + name + "\nActivities: " + activities);
    };
    Consumer<Student> studentConsumer = (student) -> {
        if(predicate1.and(predicate2).test(student))
            nameAndActivities.accept(student.getName(), student.getActivities());
    };
    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        new PredicateConsumerExample().printStudentNameAndActivities(studentList);
    }

    public void printStudentNameAndActivities(List<Student> students) {
        students.forEach(studentConsumer);
    }
}
