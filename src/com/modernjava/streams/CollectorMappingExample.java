package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorMappingExample {
    public static void main(String[] args) {
        //map get only names
        List<String> namesList = Instructors.getAll().stream()
                .map(Instructor::getName)
                .collect(Collectors.toList());
        namesList.forEach(System.out::println);

        namesList= Instructors.getAll().stream()
                .collect(Collectors.mapping(Instructor::getName, Collectors.toList()));
        namesList.forEach(System.out::println);
        //mapping create hashmap
        System.out.println("***mapping create hashmap***");
        HashMap<String, List<String>> collect = Instructors.getAll().stream().
                collect(Collectors.groupingBy(Instructor::getName,
                HashMap::new, Collectors.mapping(Instructor::getTitle, Collectors.toList())));

        Map<String, List<Instructor>> collect1 = Instructors.getAll().stream().
                collect(Collectors.groupingBy(Instructor::getName,
                        Collectors.toList()));

        Map<String,String> haMap= Instructors.getAll().stream()
                .collect(Collectors.toMap(Instructor::getName,Instructor::getGender));
        haMap.forEach((s, s2) -> System.out.println(s+":"+s2));

        //Instructors by their gorup years of experience
        System.out.println("***Instructors by their gorup years of experience and value as Name***");
        Map<Integer, List<String>> mapYearsOfExperienceAndNames = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(Instructor::getName, Collectors.toList())));

        mapYearsOfExperienceAndNames.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });


        System.out.println("---if you need key as yr of exp and value as List<Instructor>");
        Instructors.getAll().stream().
        collect(Collectors.groupingBy(
                Instructor::getYearsOfExperience,Collectors.toList()
        )).forEach((integer, instructors) ->
                        System.out.println(integer+":"+instructors)
                );




    }
}
