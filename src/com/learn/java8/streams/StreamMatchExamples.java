package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;

public class StreamMatchExamples {
    public static void main(String[] args) {
        StreamMatchExamples match = new StreamMatchExamples();
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Any Match Result: " + match.anyMatchExample(studentList));
        System.out.println("All Match Result: " + match.allMatchExample(studentList));
        System.out.println("None Match Result: " + match.noneMatch(studentList));
    }
    public boolean anyMatchExample(List<Student> students) {
        return students.stream()
                .anyMatch(student -> student.getGpa() >= 3.9);
    }

    public boolean allMatchExample(List<Student> students) {
        return students.stream().allMatch(s -> (s.getGpa() >= 3.5));
    }

    public boolean noneMatch(List<Student> students) {
        return students.stream().noneMatch(s->s.getGpa()>=5.0);
    }
}
