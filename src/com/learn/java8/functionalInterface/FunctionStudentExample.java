package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {
    static Function<List<Student>, Map<String, Double>> studentGPAMap = (studentList) -> {
        Map<String, Double> map = new HashMap<>();
        studentList.forEach(student -> {
            if (PredicateExampleWithStudent.ps.test(student)) {
                map.put(student.getName(), student.getGpa());
            }
        });
        return map;
    };
    public static void main(String[] args) {
        System.out.println(studentGPAMap.apply(StudentDataBase.getAllStudents()));
    }

}
