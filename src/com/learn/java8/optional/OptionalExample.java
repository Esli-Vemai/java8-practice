package com.learn.java8.optional;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String name = returnStudenName();
       /* if(name!=null) {
            System.out.println("Length of student name: " + name.length());
        } else {
            System.out.println("Student name not found");
        }*/
        //System.out.println(name!=null ? "Length of student name: " + name.length() : "Student name not found");

        Optional<String> optionalName = returnStudentNameWithOptional();
        System.out.println(optionalName.isPresent() ? "Length of student name: " + optionalName.get().length()
                : "Student name not found");
    }

    public static String returnStudenName() {
        Student studentObj = StudentDataBase.studentSupplier.get();
        if(studentObj!=null)
            return  studentObj.getName();

        return null;
    }

    public static Optional<String> returnStudentNameWithOptional() {
        //Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);
        if(optionalStudent.isPresent()) {
            //optionalStudent.get(); // Student
            return optionalStudent.map(Student::getName); // Optional<String>

        // this part of code is redundant coz
        // optionalStudent.map(Student::getName) -->> will return Optional.empty() if  Student::getName is null
        } else {
            return Optional.empty(); // Represents an optional object with no value
        }
    }
}
