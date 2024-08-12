package com.modernjava.streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class BoxingUnBoxingExample {
    public static void main(String[] args) {
        List<Integer> numbers;

        IntStream numStream = IntStream.rangeClosed(0,5); //primitive int stream
        numbers = numStream.boxed().collect(Collectors.toList());
        numbers.forEach(System.out::println);

        IntStream.rangeClosed(0,5).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(0,5).collect(ArrayList::new,ArrayList::add,
                        (objects, objects2) -> objects.add(objects2))
        .forEach(s-> System.out.println(s));


        Optional<Integer> sum = numbers.stream().reduce((a,b)-> a + b);
        if (sum.isPresent())
        System.out.println (sum.get());

        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);


    }
}
