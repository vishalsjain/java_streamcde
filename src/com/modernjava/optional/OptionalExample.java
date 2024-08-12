package com.modernjava.optional;

import java.util.Arrays;
import java.util.Optional;

public class
OptionalExample {
    public static void main(String[] args) {
//Optional opt1=Optional.of(null);//this gives NPE in case of null value

        Optional opt=Optional.ofNullable(null);
       //\ System.out.println(opt.get());// while it gives common exception and not NPE
        //a.util.NoSuchElementException: No value present
        opt.ifPresent(s->System.out.println(s));

       // Integer[] numbers = new Integer[10];
       // int number = numbers[1].intValue();
       // System.out.println("number = " + number);
        
        Optional<String> optionalString = Optional.of("Hello World");
        System.out.println("optionalString = " + optionalString);

        System.out.println("getWords:" + getWords());

    }

    public static Optional<String>  getWords() {
        String[] words = new String[10];
        Optional<String> optionalS = Optional.ofNullable(words[1]);
        if (optionalS.isPresent())
            return optionalS;
        else
            return Optional.empty();
    }
}
