package com.modernjava.funcprogramming;

import java.util.List;

@FunctionalInterface
public interface InstructorFunctionalInterface {

    public abstract Instructor getInstructorObject(String name, int yearsOfExperience, String title, String gender,
                                                  boolean onlineCourses, List<String> courses);
}
