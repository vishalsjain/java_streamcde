package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
//instructorname,list<course>
        Instructors.getAll().stream()
                .collect(Collectors.toMap(Instructor::getName,
                        Instructor::getCourses)).forEach((s,s1)->
                        System.out.println("List:"+s+":"+s1));

        //Get a list of all the courses which instructors offers
        Set<String> instructorsCourses = Instructors.getAll().stream()
                                        .map(Instructor::getCourses)
                                        .flatMap(List::stream)
                                        .collect(Collectors.toSet());
        System.out.println(instructorsCourses);


        //vishaljain
        System.out.println("---");

       Set<String> courStr= Instructors.getAll().stream()
               .peek(s-> System.out.println("Instructor Data:"+s))
               .filter(s-> s.isOnlineCourses())
                .flatMap(s->s.getCourses().stream())
                .collect(Collectors.toSet())
                ;
        System.out.println(courStr);

        System.out.println("----2--");
        System.out.println(
                Instructors.getAll().stream()
                .peek(s-> System.out.println("Instructor Data:"+s))
                .filter(s-> s.isOnlineCourses())
                .flatMap(s->s.getCourses().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList())
        );
              ;
        Map<Object, Object> mapStr=Instructors.getAll().stream()

                .collect(Collectors.toMap(s->s.getName(),s->s.getCourses().size()))
                ;//Code to get list of courses count for each instructor
        System.out.println("vishal:"+mapStr);
    }
}
