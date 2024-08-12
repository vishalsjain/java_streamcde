package com.modernjava.funcprogramming;

import java.util.function.Predicate;

public class ConvertToMethodReferenceExample {
    public static void main(String[] args) {
        ConvertToMethodReferenceExample as=new ConvertToMethodReferenceExample();
        Predicate<Instructor> p2 =   as::greaterThanTenYearsOfExperience;
       // Predicate<Instructor> p2 = ConvertToMethodReferenceExample::greaterThanTenYearsOfExperience;
// above line need method to be static if we want to use.
        Instructors.getAll().forEach(instructor -> {
                if (p2.test(instructor)){
                    System.out.println(instructor);
                }
        });
    }
    public  boolean greaterThanTenYearsOfExperience(Instructor instructor) {
        if (instructor.getYearsOfExperience()>10)
            return true;
        return false;
    }
}
