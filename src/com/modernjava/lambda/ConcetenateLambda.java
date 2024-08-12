package com.modernjava.lambda;

public class ConcetenateLambda {

    public static void main(String[] args) {
        ConcatenateInterface concatenateInterface = (a,b) -> a + " " + b;
        System.out.println(concatenateInterface.sconcat("Hello", "World"));
        System.out.println( ((ConcatenateInterface) ((a, b) -> a + " " + b)).sconcat("Hello","Worldd"));
    }
}
