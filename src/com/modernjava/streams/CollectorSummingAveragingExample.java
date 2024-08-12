package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.stream.Collectors;

public class CollectorSummingAveragingExample {
    public static void main(String[] args) {
        Instructors.getAll().stream().forEach(System.out::println);
        System.out.println("---Key is gender and avlue is total yr of exp---");


        Instructors.getAll().stream().
                collect(Collectors.groupingBy(Instructor::getGender,
                        Collectors.summingInt(Instructor::getYearsOfExperience)))
                .forEach((s, integer) ->
                        System.out.println(s+":"+integer)
                );
        Instructors.getAll().stream().
        collect(Collectors.groupingBy(Instructor::getGender,
                Collectors.mapping(Instructor::getYearsOfExperience,Collectors.summingInt(
                        Integer::intValue
                )))).forEach((s,s1)-> System.out.println(s+":"+s1));

        //year of exp and there count
        Instructors.getAll().stream().
        collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                Collectors.counting())).forEach((integer, aLong) ->
                        System.out.println(integer+":count:"+aLong));

        //sum of years of experience of all instructor
        int sum = 0;
        for (Instructor instructor : Instructors.getAll()) {
            int yearsOfExperience = instructor.getYearsOfExperience();
            sum += yearsOfExperience;
        }
        System.out.println("sum = " + sum);

        //calculate average of years of experience of all instructors
        double average = Instructors.getAll().stream()
                .collect(Collectors.averagingInt(Instructor::getYearsOfExperience));

        System.out.println("average = " + average);

average=        Instructors.getAll().stream().mapToInt(Instructor::getYearsOfExperience)
                .average().getAsDouble();


        System.out.println("--key is gender and value if avg of exp for that gender---");
        Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getGender,
                Collectors.averagingInt(Instructor::getYearsOfExperience)))
                .forEach((s, aDouble) -> System.out.println(s+":"+aDouble));
    }
}
