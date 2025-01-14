package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample1 {
    public static void main(String[] args) {
        //group list of name by their length
        List<String> names = List.of("Syed", "Mike", "Jenny", "Gene", "Rajeev");
        Map<Integer,  List<String>> result = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("result = " + result);

        System.out.println("-----------------");
        //grouping by instructors by their gender
        Map<String, List<Instructor>> instructorByGender = Instructors.getAll()
                .stream().collect(Collectors.groupingBy(Instructor::getGender));

        instructorByGender.forEach((key,value) -> {
            System.out.println("key = " + key + " value = " + value);
        });

        Instructors.getAll().stream().collect(
                Collectors.partitioningBy(x->x.getGender().equalsIgnoreCase("M")))
                .forEach((aBoolean, instructors) ->
                        System.out.println(aBoolean+":"+instructors));
        System.out.println("-----------------");
        //grouping by experience where >10 years of experience is classified
        //as Senior and others are junior

       Instructors.getAll()
                .stream().collect(Collectors.groupingBy(instructor -> instructor
                .getYearsOfExperience()>10 ? "SENIOR": "JUNIOR",
                       Collectors.mapping(Instructor::getName, Collectors.toList())))
               .forEach((a,a1)-> System.out.println("vishal:"+a+":"+a1));


    }
}
