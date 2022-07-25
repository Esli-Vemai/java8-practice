package com.learn.java8.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "fff", "ccc", "kkk", "eee");
        Collections.sort(list);
        System.out.println("Collections.sort(): " + list);

        List<String> list1 = Arrays.asList("aaa", "fff", "ccc", "kkk", "eee");
        list1.sort(Comparator.naturalOrder());
        System.out.println("Java 8 sort(): " + list1);

        list1.sort(Comparator.reverseOrder());
        System.out.println("Java 8 reverse()" + list1);

        List<String> list2 = Arrays.asList("aaa", "ffaf", "cacc", "kakk", "eeea");
        list2.replaceAll(a -> a.toUpperCase());
        list2.forEach(a -> System.out.println(a));
    }
}
