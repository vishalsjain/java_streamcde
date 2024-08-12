package com.modernjava.defaults;

public class MultipleInheritanceDebuggingExample implements  InterfaceA, InterfaceD{

    public void sumA (int num1, int num2){
        InterfaceA.super.sumA(num1,num2);
        System.out.println("MultipleInheritanceDebuggingExample.sumA" + (num1 + num2)) ;
    }//commenting this code give compilation issue as we need to explicitly define this method for interface deafult mentods


}
