package com.modernjava.optional;

import java.util.Optional;

public class OptionalOrElseThrowExample {
    public static void main(String[] args) {
        //orElse
        Integer[] numbers = new Integer[10]; 
        numbers[0] = 1;
        Optional<Integer> number = Optional.ofNullable(numbers[0]);
        int result = number.orElse(getOther());
        System.out.println("result = " + result);

        //orElseGet
        result = number.orElseGet(() -> {
            System.out.println("in orelseget");
            return   -1;
        });
        System.out.println("result - orElseGet = " + result);

        //orElseThrow
        try {
            result = number.orElseThrow(Exception::new);
            System.out.println("result orElseThrow = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getOther() {
        System.out.println("in get method to see eager loading");
        return -1;
    }
}
