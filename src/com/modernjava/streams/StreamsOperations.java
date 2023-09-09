package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsOperations {
    public static void main(String[] args) {
        //count   distinct
        Instructors.getAll().stream()
                .flatMap(a->a.getCourses().stream()).distinct()
                .collect(Collectors.groupingBy(String::toString,Collectors.counting()))
                .forEach((s, aLong) -> System.out.println(s+"::"+aLong));




        Long count = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .count();

        System.out.println(count);
        //distinct
        List<String> courses = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(courses);

        //anymatch, allmatch and nonmatch


        boolean match = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .noneMatch(s -> s.startsWith("J"));
        System.out.println("&****");
        System.out.println(match);

//vishaljain
        List<String> list= Arrays.asList("Angular Programming", "C Programming", "C++ Programming", "CI/CD",
                "Java Multi-Threaded Programming", "Java Programming", "Multi-Threaded Programming",
                "Python Programming", "React Native", "Unit Testing");


        System.out.println("---------");
boolean status=Instructors.getAll().stream().flatMap(i->i.getCourses().stream())
        .distinct().allMatch(l->list.contains(l));
        System.out.println("status:"+status);
    }
}
