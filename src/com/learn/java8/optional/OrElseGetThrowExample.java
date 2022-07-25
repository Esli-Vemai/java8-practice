package com.learn.java8.optional;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Optional;

public class OrElseGetThrowExample {
    public static void main(String[] args) {
        System.out.println("orElse(): " + orElse());
        System.out.println("orElseGet(): " + orElseGet());
        try {
            System.out.println("orElseThrow(): " + orElseThrow());
        } catch (RuntimeException exp) {
            System.out.println("orElseThrow() Exception: " + exp.getMessage());
        }

    }
    public static String orElse() {
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        return student.map(Student::getName).orElse("Default value");
    }
    
    public static String orElseGet() {
        //Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> student = Optional.ofNullable(null);
        return student.map(Student::getName).orElseGet(() -> "Default value by Supplier");
    }

    public static String orElseThrow() {
        //Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> student = Optional.ofNullable(null);
        return student.map(Student::getName).orElseThrow(() -> new RuntimeException("No student object found"));
    }
}
