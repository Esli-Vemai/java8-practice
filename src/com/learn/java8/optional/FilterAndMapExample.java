package com.learn.java8.optional;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterAndMapExample {
    private static Predicate<Student> gpa = student -> student.getGpa() >= 3.5;
    public static void main(String[] args) {
        optionalFilter();
        optionalMap();

    }

    public static void optionalFilter() {
       Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
       student.filter(gpa).ifPresent(System.out::print);
    }

    public static void optionalMap() {
        /*Optional<List<Student>> students = Optional.ofNullable(StudentDataBase.getAllStudents());
        Stream<String> student = students.get().stream().filter(gpa).map(Student::getName);
        student.forEach(s-> System.out.println(s));*/

        Optional<Student> students = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        students.filter(gpa).map(Student::getName).ifPresent(System.out::print);

    }
}
