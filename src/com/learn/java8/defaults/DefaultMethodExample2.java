package com.learn.java8.defaults;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodExample2 {
    private static Comparator<Student> compareByName = Comparator.comparing(Student::getName);
    private static Comparator<Student> compareByGrade = Comparator.comparingInt(Student::getGradeLevel);
    private static Consumer<Student> studentConsumer = student -> System.out.println("Student: " + student);

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Before sorting: " );
        studentList.forEach(System.out::println);
        //byNameComparator(studentList);
        //byGPAComparator(studentList);
        //comparatorChaining(studentList);
        compareWithNullValues(studentList);
    }

    public static void byNameComparator(List<Student> studentList) {
        System.out.println("After byNameComparator: ");
        studentList.sort(compareByName);
        studentList.forEach(System.out::println);
    }

    public static void byGPAComparator(List<Student> studentList) {
        System.out.println("After byGPAComparator: ");
        //studentList.sort(Comparator.comparing(student -> student.getGpa()));
        studentList.sort(Comparator.comparingDouble(Student::getGpa));
        studentList.forEach(studentConsumer);
    }

    public static void comparatorChaining(List<Student> students) {
        System.out.println("After comparatorChaining : ");
        //students.sort(compareByGrade.thenComparing(compareByName)); // accepts a Comparator as second input
        students.sort(compareByGrade.thenComparing(Student::getName)); // accepts a Function as second input
        students.forEach(studentConsumer);
    }


    public static void compareWithNullValues(List<Student> studentList) {
        System.out.println("After compareWithNullValues: ");
        studentList.sort( Comparator.nullsFirst(compareByName));
        //studentList.sort(Comparator.nullsLast(compareByName));
        studentList.forEach(studentConsumer);
    }

}
