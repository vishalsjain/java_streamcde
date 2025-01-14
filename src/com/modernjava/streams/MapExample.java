package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        //return only instructor names from the instructor list
        Set<String> instructorNames = Instructors.getAll().stream()
                                        .map(Instructor::getName)
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toSet());
        System.out.println(instructorNames);


    //VishalJain
        System.out.println("-----------");
        List<String> names=Instructors.getAll().stream()
                .map(Instructor::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("names:"+names);

        Instructors.getAll().stream()
                .mapToInt(Instructor::getYearsOfExperience).peek(System.out::println)
                .forEach(s-> System.out.println("loop:"+s));


    }
}
