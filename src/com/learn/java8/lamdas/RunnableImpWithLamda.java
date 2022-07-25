package com.learn.java8.lamdas;

public class RunnableImpWithLamda {

    public static void main(String[] args) {
        /**
         * Using the old way
         */

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable legacy");
            }
        };
        new Thread(runnable).start();


        /**
         * Using Lamda Exp
         */
        Runnable runnableLamda = () -> {
            System.out.println("Inside Runnable with Lamda");
        };
        new Thread(runnableLamda).start();

        // can also pass lamda exp as method arg
        new Thread(() -> System.out.println("Inside Runnable with Lamda as method arg")).start();
    }
}
