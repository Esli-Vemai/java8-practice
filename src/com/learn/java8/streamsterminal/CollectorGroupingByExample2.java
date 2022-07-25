package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class CollectorGroupingByExample2 {
    public static void main(String[] args) {
        //groupingByTwoLevels();
        //groupingByTwoLevel2();
        //groupingByTwoLevel3();

        List lst = Arrays.asList(1,6,5,2,4);
        Set st = new HashSet();
        st.addAll(Arrays.asList(1,6,5,2,4));
        System.out.println("List: " + lst);
        System.out.println("Set: " + st);
    }

    public static void groupingByTwoLevels() {
        Map<String, Integer> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName, summingInt(Student::getNoteBooks)));

        studentMap.keySet().forEach(k -> System.out.println("Student: " + k + ". Total Notebooks: " + studentMap.get(k)));
    }

    public static void groupingByTwoLevel2() {
        Map<Integer, Map<String, List<Student>>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() >= 3.8 ? "Outstanding" : "Average")));

        studentMap.keySet().forEach(k -> System.out.println("Grade: " + k + ". Value: " + studentMap.get(k)));

      /* studentMap.entrySet().stream()
              .flatMap(entry -> entry.getValue().entrySet().stream())
               .forEach(secEntry -> {
            System.out.println("Result: " + secEntry.getKey() + " Students: " + secEntry.getValue());
        });*/
    }

    public static void groupingByTwoLevel3() {
        Map<Integer, Set<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel, toSet()));

        studentMap.keySet().forEach(k -> System.out.println("Grade: " + k + ". Value: " + studentMap.get(k)));

        Map<Integer, List<Student>> studentMap2 = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel, toList()));

        System.out.println("List=========================");
        studentMap.keySet().forEach(k -> System.out.println("Grade: " + k + ". Value: " + studentMap.get(k)));
    }
}
