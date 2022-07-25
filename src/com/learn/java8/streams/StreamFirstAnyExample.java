package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class StreamFirstAnyExample {

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        Optional<String> name = findFirst(studentList);
        if (name.isPresent()) {
            System.out.println("The first student whose GPA is >= 3.6: " + name.get());
        } else {
            System.out.println("No valid input found");
        }

        System.out.println("==============================");
        Optional<String> anyName = findAny(studentList);
        if (anyName.isPresent()) {
            System.out.println("Any student whose GPA is >=3.6: " + anyName.get());
        } else {
            System.out.println("No valid input found");
        }
    }

    public static Optional<String> findFirst(List<Student> students) {
        return students.stream().filter(s->s.getGpa()>=3.6).map(Student::getName).findFirst();
    }

    public static Optional<String> findAny(List<Student> students) {
        return students.stream().filter(s->s.getGpa()>=3.6).map(Student::getName).findAny();
    }
}
