package com.modernjava.vishalpractice;

public class RunnableTestClass {

    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test1");
            }
        });
        t.start();

        Thread t1=new Thread(()->
                System.out.println("Test2")
        );
        t1.start();



    }
}
