package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class CollectorsMinByMaxByExample {
    public static void main(String[] args) {
        List<Student> students = StudentDataBase.getAllStudents();
        Optional<Student> maxGPA = maxByExample(students);
        System.out.print("maxBy(): ");
        System.out.println(maxGPA.isPresent()? maxGPA.get(): "No input");

        Optional<Student> minGPA = minByExample(students);
        System.out.print("minBy(): ");
        System.out.println(minGPA.isPresent()? minGPA.get(): "No input");
    }

    public static Optional<Student> maxByExample(List<Student> studentList) {
        return studentList.stream()
                .collect(maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> minByExample(List<Student> studentList) {
        return studentList.stream()
                .collect(minBy(Comparator.comparing(Student::getGpa)));
    }
}
