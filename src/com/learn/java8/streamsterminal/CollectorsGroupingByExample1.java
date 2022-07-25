package com.learn.java8.streamsterminal;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsGroupingByExample1 {
    public static void main(String[] args) {
        grouptingBy_GenderExample();
    }

    public static void grouptingBy_GenderExample() {
        Map<String, List<Student>> byGender = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));

        //System.out.println(byGender);
        System.out.println("<<< printing using Lamdas. Here we do not need to convert to entrySet>>>");
        byGender.forEach((k,v) -> System.out.println("key: " + k + "\nvalue: " + v));

       /* System.out.println("<<<< Using keySet and Lamdas >>>>");
        byGender.keySet().forEach(k-> System.out.println("Key: " + k + "\nValue: " + byGender.get(k)));

        System.out.println("<<<<Using values and Lamda>>>>");
        byGender.values().forEach(value -> System.out.println("Values: " + value));

        System.out.println("<<<<<<<< Using StreamAPI. Using this only when doing additional steam processing." +
                "Otherwise the above forEach() method with Lamdas is fine. >>>>>>");
        byGender.entrySet().stream()
                // ... some other Stream processings
                .forEach(entry -> System.out.println("Key: " + entry.getKey() + "\nValue: " + entry.getValue()));
*/

        System.out.println("=====================================================");
        customizedGroupingBy();
    }

    public static void customizedGroupingBy() {
        Predicate<Student> average = student -> student.getGpa() >=3.4 && student.getGpa() <=3.6;

        Map<String, List<Student>> customisedGrouping = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> {
                        //student.getGpa() >= 3.9 ? "Outstanding" : "Average"));
                    //if(student.getGpa() >= 3.4 && student.getGpa() <= 3.6) {
                    if(average.test(student)) {
                        return "Average";
                    } else if(student.getGpa() >= 3.6 && student.getGpa() <= 3.9) {
                        return "Good";
                    } else {
                        return "Outstanding";
                    }
                }));
        System.out.println("<<<<<<<<<<<<< customisedGrouping >>>>>>>>>>>>>>>");

        customisedGrouping.forEach((k, v) -> System.out.println("Key: " + k + "\nValue" + v));
    }
}
