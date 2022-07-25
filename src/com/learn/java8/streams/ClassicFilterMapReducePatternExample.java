package com.learn.java8.streams;

import com.learn.java8.data.Student;
import com.learn.java8.data.StudentDataBase;

import java.util.Optional;

public class ClassicFilterMapReducePatternExample {
    public static void main(String[] args) {
        System.out.println("Total no of notebooks: " + getTotalNoOfNotebooks());
        Optional<Integer> noOfBook = getTotalNoOfNotebooksWithOptional();
        if (noOfBook.isPresent()){
            System.out.println("Total notebooks (Optional: ) " + noOfBook.get());
        }
    }

    public static int getTotalNoOfNotebooks() {
        // The pattern is stream -> filter -> map -> filter -> reduce
        int noOfBooks = StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter(student -> student.getGender().equals("female")) // Stream<Student>
                .map(Student::getNoteBooks)// Stream<Integers>
                .filter(no -> no >= 11) //Stream<Integers>
                //.reduce(0, (n1, n2) -> n1+n2);
                //or we can use the sum() method of Integer class
                .reduce(0, Integer::sum); // int

        return noOfBooks;

    }

    public static Optional<Integer> getTotalNoOfNotebooksWithOptional() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGradeLevel()>3)
                .map(Student::getNoteBooks)
                .reduce((n1, n2) -> n1+n2);
    }
}
