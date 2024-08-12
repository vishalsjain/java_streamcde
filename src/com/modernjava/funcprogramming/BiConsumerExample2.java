package com.modernjava.funcprogramming;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class BiConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        System.out.println("----Print Map---");
        instructors.stream().collect(Collectors.toMap(Instructor::getName,Instructor::getGender))
                .forEach((s, s2) -> System.out.println(s+":"+s2));
        System.out.println("----Print Map Object---");
        instructors.stream().map(instructor -> Map.of(instructor.getName(),instructor.getGender()))
                .forEach(stringStringMap ->
                        stringStringMap.entrySet().stream().forEach(stringStringEntry ->
                        System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue())
                ));

//Code to Create New Instructor object with only speific field value other part should be null
        List<Instructor> aaa=instructors.stream().map(instructor ->
                        new Instructor(instructor.getName(),instructor.getGender()))
                .collect(Collectors.toList());
        aaa.forEach(o -> System.out.println(o));
        //print out name and gender of instructors
        BiConsumer<String, String> biConsumer = (name, gender) -> System.out.println("name is :"
            + name + " and gender is: " + gender);
        instructors.forEach(instructor ->
                biConsumer.accept(instructor.getName(), instructor.getGender()));

        //print out name and list of courses
        System.out.println("--------------------");
        BiConsumer<String, List<String>> biConsumer1 = (name, courses) -> System.out.println(
                "name is " + name + " courses: " + courses);
        instructors.forEach(instructor -> {
            biConsumer1.accept(instructor.getName(), instructor.getCourses());
        });

        //print out name and gender of all instructors who teaches online
        System.out.println("----------------------");
        instructors.forEach(instructor -> {
             if (instructor.isOnlineCourses())
                 biConsumer.accept(instructor.getName(), instructor.getGender());
        });


    }
}
