package com.modernjava.funcprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    public static void main(String[] args) {
        //Bifuction 2 inputs List<Instructors> and second is predicate which will filter if instructor has online
        //courses and return a map of <String,Integer> string is name and Integer is the years of experience
        Map<String, Integer> map1 = new HashMap<>();
map1.put("1",2);
int i1=0;
        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses()==true;
        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String,Integer>> mapBiFunction =
                ((instructors, instructorPredicate) -> {
                    instructors.forEach(instructor -> {
                        if(instructorPredicate.test(instructor)){
                           // i1++;
                            map1.put(instructor.getName(), instructor.getYearsOfExperience());
                        }
                    });
                    return map1;
                });
        System.out.println(mapBiFunction.apply(Instructors.getAll(), p1));
    }
}
