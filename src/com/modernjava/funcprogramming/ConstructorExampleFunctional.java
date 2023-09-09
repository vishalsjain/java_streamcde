package com.modernjava.funcprogramming;

import java.util.List;

public class ConstructorExampleFunctional {

    public static void main(String[] args) {

        //Implementation via basic function
        InstructorFunctionalInterface inst=(String name, int yearsOfExperience, String title, String gender,
                                            boolean onlineCourses, List<String> courses)->
                new Instructor( name, yearsOfExperience, title, gender,
        onlineCourses, courses);

        //Constructor Reference Example
        InstructorFunctionalInterface inst1=Instructor::new;


        System.out.println(
                inst.getInstructorObject("vishal",2,"jain","male",true,
                        null));


        System.out.println(
                inst1.getInstructorObject("vishal1",2,"jain","male",true,
                        null));



    }
}
