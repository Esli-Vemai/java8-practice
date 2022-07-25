package com.learn.java8.optional;

import com.learn.java8.data.Bike;
import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;
import org.w3c.dom.ls.LSOutput;

import java.util.Optional;

public class FlatMapExample {
    public static void main(String[] args) {
        flatMapExample();
    }

    public static void flatMapExample() {
        Optional<Student> studentOptional = StudentDataBase.getOptionalStudent();
        Optional<String> bike = studentOptional.filter(student -> student.getGpa() >= 3.5) // returns -> Optional<Student ... Optional<Bike>>
                //.flatMap(student -> student.getBike())
                .flatMap(Student::getBike) //returns -> Optional<Bike>
                .map(Bike::getName);

        System.out.println(bike.isPresent() ? bike.get():"No data");
        bike.ifPresent((s) -> System.out.println(s));
    }
}
