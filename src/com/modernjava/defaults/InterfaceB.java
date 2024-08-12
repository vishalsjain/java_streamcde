package com.modernjava.defaults;

public interface InterfaceB extends InterfaceA
    //here since there is inheritance interfaceb suma is getting called and no compilation issue
{
    default void sumB(int num1, int num2){
        System.out.println("InterfaceB.sumB " + (num1 + num2));
    }

    default void sumA(int num1, int num2){
        System.out.println("InterfaceB.sumA " + (num1 + num2));
    }
}
