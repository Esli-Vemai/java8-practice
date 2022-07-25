package com.learn.java8.optional;

import java.util.Optional;

public class IsPresentIfPresentExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("Hello from Optional of Nullable type");
        System.out.println(optional.isPresent() ? optional.get():"No data");
        optional.ifPresent(System.out::print);
    }
}
