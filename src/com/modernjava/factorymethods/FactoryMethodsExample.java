package com.modernjava.factorymethods;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class FactoryMethodsExample {

    public static void main(String[] args) {
        //How we used to create unmodifiable list pre Java 9
        List<String> names = new ArrayList();
        names.add("Syed");
        names.add("Mike");
        names.add("Jenny");
        names = Collections.unmodifiableList(names);
        System.out.println("names = " + names);
        //factory methods of Java 9
        List<String> names2 = List.of("Syed", "Mike", "Jenny");
                     names2=Arrays.asList("Syed", "Mike", "Jenny");//or even this
        System.out.println("names2 = " + names2);
        Set<String> set = Set.of("Syed", "Mike", "Jenny");
        System.out.println("set = " + set);
        Map<String, String> map = Map.of("Grade1", "Syed", "Grade2", "Mike");
        System.out.println("map = " + map);
        //modify the list
         //names2.add("Gene");
       // set= Set.of("Syed", "Syed", "Mike");
        //  names.sort(Comparator.naturalOrder());//this given exception as its unmodifed list
        List.of(names).stream().sorted().forEach(System.out::println);
     //   Collections.sort(names,Comparator.naturalOrder());

        List<List<String>> str=List.of(names);
        str.get(0).stream().sorted(Comparator.naturalOrder());
        System.out.println(str);
        }
}
