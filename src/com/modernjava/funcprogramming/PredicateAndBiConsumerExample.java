package com.modernjava.funcprogramming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndBiConsumerExample {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        //all instructor who teaches online
        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses()==true;
        //instructor experience is >10
        Predicate<Instructor> p2 = (i) -> i.getYearsOfExperience()>10;

        //Biconsumer print name and courses
        BiConsumer<String, List<String>> biConsumer = (name, courses) ->
                System.out.println("name is: " + name + " courses : " + courses);

        instructors.forEach(instructor -> {
            if(p1.and(p2).test(instructor))
                biConsumer.accept(instructor.getName(), instructor.getCourses());
        });

        System.out.println("****************");
Predicate<Instructor> p5= a->a.isOnlineCourses();
        Predicate<Instructor> p6= a->a.yearsOfExperience>10;
        BiConsumer<String,List<String>> c6=(name,cource)-> System.out.println(name+"**"+cource);
        instructors.stream().filter(a->p5.and(p6).test(a)).forEach(
                a-> c6.accept(a.getName(),a.getCourses())
        );

    }
}
