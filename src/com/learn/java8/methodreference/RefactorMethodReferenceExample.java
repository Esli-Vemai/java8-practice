package com.learn.java8.methodreference;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> predicate = RefactorMethodReferenceExample::getGradeLevel;
    public static void main(String[] args) {
        System.out.println("Grade greater than 3?: " + getGradeLevel(StudentDataBase.studentSupplier.get()));
    }

    public static boolean getGradeLevel(Student student) {
        return student.getGradeLevel() >=3;
    }

}
