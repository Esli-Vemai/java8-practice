package com.learn.java8.functionalInterface;

import java.util.function.Function;

public class FunctionExample {
    private static Function<String, String> func1 = string ->string.toUpperCase();
    private static Function<String, String> functionAndthen = string -> string.concat("Concat");
    private static Function<String, String> functionCompose = string ->string.toLowerCase().concat("CONcat");

    public static void main(String[] args) {
        functionExample();
    }

    public static void functionExample() {
        System.out.println(func1.apply("java8"));
        System.out.println("AndThen: " + func1.andThen(functionAndthen).apply("java8"));
        System.out.println("AndThen2: " + functionAndthen.apply("java8"));
        System.out.println("Compose: " + func1.compose(functionAndthen).apply("java8"));
        System.out.println("Compose2: " + func1.compose(functionCompose).apply("java8")); //JAVA8CONCAT

        System.out.println("AndThen3: " + func1.andThen(functionCompose).apply("java8")); //java8CONcat
        System.out.println("Compose3: " + func1.compose(functionCompose).apply("java8")); //JAVA8CONCAT
    }
}
