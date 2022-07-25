package com.learn.java8.methodreference;

import com.learn.java8.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {
    /**
     * We can only use Constructor reference with Functional interfaces
     */

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = Student::new;
        System.out.println(studentSupplier.get());

        Function<String, Student> studentFunction = Student::new;
        System.out.println(studentFunction.apply("Name from Function"));

    }
}
