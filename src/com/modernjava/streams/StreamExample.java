package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //creating a map of names and course of instructors who teaches
        //online have more than 10 years of experience

        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses();
        Predicate<Instructor> p2 = (i) -> i.getYearsOfExperience()>10;

        List<Instructor> list = Instructors.getAll();

Stream s=        list.stream().filter(p1).filter(p2);//you will not be able to debug at this point as there is no terminal pperation like foreach or collect
s.forEach(System.out::println);

        Map<String, List<String>> map = list.stream().peek(s2-> System.out.println("peekS:"+s2))
                                .filter(p1).peek(s2-> System.out.println("peek1:"+s2))
                                .filter(p2)
                                .peek(s2-> System.out.println("peek2:"+s2))
                                .collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));
        System.out.println("Map:"+map);

        List list1=
    list.stream()
                .filter(p1)
                .filter(p2)
                .peek(s1-> System.out.println(s1))
                .collect(Collectors.toList());

        System.out.println("List1:"+list1);

    }
}
