package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> {
            return new Student("Sophia",4,3.5,"female",10, Arrays.asList("swimming", "dancing","football"));
        };

        System.out.println("Student supplier: " + studentSupplier.get());

        //Returning list of students
        Supplier<List<Student>> studentList = () -> StudentDataBase.getAllStudents();
        System.out.println("List of students: " + studentList.get());

        //IntSupplier example
        IntSupplier intSupplier = () -> 1;
        System.out.println(intSupplier.getAsInt());
    }
}
