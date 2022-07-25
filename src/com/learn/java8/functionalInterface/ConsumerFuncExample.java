package com.learn.java8.functionalInterface;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerFuncExample {
    Consumer<Student> s1 = student -> System.out.println(student);
    Consumer<Student> s2 = student -> System.out.println(student.getName());
    Consumer<Student> s3 = student -> System.out.println(student.getActivities());
    List<Student> studentsList = StudentDataBase.getAllStudents();


    /**
     * Example implementation of Consumer functional interface
     * Consumer accepts an input and returns nothing
     */
    public static void main(String[] args) {
        Consumer<String> consumerEg = (s) -> System.out.println(s.toUpperCase());
        consumerEg.accept("java 8");
        ConsumerFuncExample consumerExample = new ConsumerFuncExample();

        consumerExample.printStudent();
        consumerExample.printStudentNameAndActivities();
        consumerExample.printStudentNameAndActivitiesWithCondition();
    }


    //Using real world example
    public void printStudent() {
        System.out.println("<<<<<<<< Inside printStudent() ");
        studentsList.forEach(s1);
    }

    public void printStudentNameAndActivities() {
        System.out.println(" <<<<<<<< Inside printStudentName&Activities");
        studentsList.forEach(s2.andThen(s3)); //Consumer chaining
    }

    public void printStudentNameAndActivitiesWithCondition() {
        System.out.println("<<<<<<<< Inside printStudentNameAndActivitiesWithCondition");
        studentsList.forEach(student -> {if(student.getGpa()>=3.9) {
            s2.andThen(s3).accept(student);
        }
        });

    }

}
