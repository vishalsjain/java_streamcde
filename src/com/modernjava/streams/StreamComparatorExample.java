package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamComparatorExample {
    public static void main(String[] args) {
        //retuning all instructors sorted by their name
        List<Instructor> list = Instructors.getAll().stream()
                            .sorted(Comparator.comparing(Instructor::getName).reversed())
                            .collect(Collectors.toList());

        list.forEach(System.out::println);


        //vishaljain
        System.out.println("---");
        List<Instructor> list1=Instructors.getAll().stream().sorted(Comparator.comparing(Instructor::getName))
                .collect(Collectors.toList());
        list1.forEach(System.out::println);

        System.out.println("--2-");
        List<Instructor> list2=Instructors.getAll().stream()
                .sorted((a,b)->
                {
                    if(a.getCourses().hashCode()<(b.getCourses().hashCode())) return 0;
                    else return -1;
                })
                .collect(Collectors.toList());
        list2.forEach(System.out::println);

        System.out.println("--3-");//getMap obeject
        Map<String, List<String>> map=Instructors.getAll().stream().
                collect(Collectors.toMap(Instructor::getName,Instructor::getCourses))
                ;
        System.out.println("map:"+map);
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(System.out::println);

        System.out.println("vishal jain");
        map.entrySet().stream().
                sorted(Comparator.comparing(s->s.getKey(),
                        ((a,b)->{
                            return a.compareTo(b);
                        }))
                )
                .forEach(System.out::println);

        System.out.println("Mapp sort by Key");
        map.entrySet().stream().
                sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("Mapp sort by value");
        map.entrySet().stream().sorted(Comparator.comparing(a->a.getValue().toString()));


        map.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.comparing(
                        l->l.get(0)
                )))
                .forEach(System.out::println);


        Map<String, Instructor> collect = Instructors.getAll().stream()
                .collect(Collectors.toMap(Instructor::getName,
                        s -> s));
        collect.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(stringInstructorEntry -> System.out.println(
                        stringInstructorEntry.getKey()
                ));
        collect.entrySet().stream().sorted(Map.Entry.
                        comparingByValue(
                                Comparator.comparing(Instructor::getName)
                        ))
                .forEach(stringInstructorEntry -> System.out.println(
                        stringInstructorEntry.getKey()
                ));

    }
}
