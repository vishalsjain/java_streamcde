package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsMinMaxExample {
    public static void main(String[] args) {
        //get instructor with min yr of exp but count can be greater then 1
        Instructors.getAll().stream().
                collect(Collectors.groupingBy(Instructor::getYearsOfExperience,Collectors.toList()))
                .entrySet().stream().sorted(
                        Map.Entry.comparingByKey()
                ).limit(1).forEach(integerListEntry ->
                        System.out.println(integerListEntry.getKey()+":"+integerListEntry.getValue()));


        //instructor with minimum years of experience
        System.out.println("------");
        Instructors.getAll().stream().mapToInt(Instructor::getYearsOfExperience).min().getAsInt();

        Instructors.getAll().stream().
                sorted(Comparator.comparing(Instructor::getYearsOfExperience)).limit(1);

        Optional<Instructor> instructor = Instructors.getAll().stream()
                .collect(Collectors.minBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        System.out.println("instructor = " + instructor);
        System.out.println("---------------");

        instructor = Instructors.getAll().stream()
                .min(Comparator.comparing(Instructor::getYearsOfExperience));
        System.out.println("instructor = " + instructor);

       instructor = Instructors.getAll().stream()
                .collect(Collectors.maxBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        System.out.println("instructor with max yr of exp = " + instructor);
        System.out.println("---------------");

        instructor = Instructors.getAll().stream()
                .max(Comparator.comparing(Instructor::getYearsOfExperience));
        System.out.println("instructor = " + instructor);


    }
}
