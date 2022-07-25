package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    private static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction =
            (studentsList, predicateFunc) -> {
            Map<String, Double> studentGpaMap = new HashMap<>();
            studentsList.forEach(student -> {
                if(predicateFunc.test(student)){
                    studentGpaMap.put(student.getName(), student.getGpa());
                }
            });

            return studentGpaMap;
            };
    public static void main(String[] args) {
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), PredicateExampleWithStudent.ps2));
    }
}
