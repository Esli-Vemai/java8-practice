package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Optional;

public class StreamReduceExample2 {
    public static void main(String[] args) {
        Optional<Student> optionalStudent = getHighestGPA();
        if (optionalStudent.isPresent()){
            System.out.println("Highest GPA: " + optionalStudent.get());
        } else {
            System.out.println("No valid data found");
        }

    }
    public static Optional<Student> getHighestGPA() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1:s2);
    }
}
