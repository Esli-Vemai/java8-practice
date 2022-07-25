package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExampleWithStudent {
    static Predicate<Student> ps = (student) -> student.getGradeLevel() >= 3;
    static Predicate<Student> ps2 = student -> student.getGpa() >= 3.9;
    private static List<Student> studentList = StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        System.out.println("=== Inside main() ===");
        filterStudentByGradeLevel();
        filterStudentByGpa();
        filterStudents();
    }

    public static void filterStudentByGradeLevel() {
        System.out.println("=====filterStudentByGradeLevel====");
        studentList.forEach(student -> {
            if(ps.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudentByGpa() {
        System.out.println("=====filterStudentByGpa()=====");
        studentList.forEach(student -> {
            if(ps2.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudents() {
        System.out.println("========filterStudents()========");
        studentList.forEach(student -> {
                    if (ps.or(ps2).negate().test(student)) {
                        System.out.println(student);
                    } else {
                        System.out.println(student);
                    }

                }
        );
    }
}
