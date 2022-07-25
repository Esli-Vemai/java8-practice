package com.learn.java8.methodreference;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {
    // className:: methodName
    static Consumer<Student> c1 = System.out::println;
    //className:: instanceMethodName
    static Consumer<Student> c2 = Student::printListOfActivities;
    public static void main(String[] args) {
        List<Student> listOfStudent = StudentDataBase.getAllStudents();
        listOfStudent.forEach(c1);
        listOfStudent.forEach(c2);
    }
}
