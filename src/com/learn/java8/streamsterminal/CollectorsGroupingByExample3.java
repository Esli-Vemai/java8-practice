package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class CollectorsGroupingByExample3 {
    public static void main(String[] args) {
        //LinkedHashMap<String, Set<Student>>
        LinkedHashMap<String, Map<Integer, List<Student>>> hashMap = StudentDataBase.getAllStudents().stream()
                //.collect(groupingBy(Student::getName, () ->new LinkedHashMap<>(), toSet()));
                //.collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));
                .collect(groupingBy(Student::getName, LinkedHashMap::new, groupingBy(Student::getGradeLevel)));

        hashMap.forEach((k,v) -> System.out.println("Key: " + k + "\nValue" + v));
    }
}
