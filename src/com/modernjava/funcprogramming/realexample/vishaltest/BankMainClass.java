package com.modernjava.funcprogramming.realexample.vishaltest;

import com.modernjava.funcprogramming.realexample.BankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankMainClass {

    public static void main(String[] args) {
       BankAccountPojo studentAccount=new BankAccountPojo(1,2100.0,"studentAccount");
        BankAccountPojo universityAccount=new BankAccountPojo(2,3000.0,"universityAccount");
        ExecutorService ex= Executors.newFixedThreadPool(10);
        BiPredicate<Double,Double> p1= (bal,amount)-> bal<amount;
        BiConsumer<String, Double> printer = (x, y) -> System.out.println(x + y);
        BiConsumer<BankAccountPojo, BankAccountPojo> printer1 = (student, university) ->
                System.out.println(Thread.currentThread().getName() + "Start balance of student account: " + student.getBalance() +
                        " University account: " + university.getBalance());
        BiConsumer<BankAccountPojo, BankAccountPojo> printer2 = (student, university) ->
                System.out.println(Thread.currentThread().getName() + "Ending balance of student account: " + student.getBalance() +
                        " University account: " + university.getBalance());




        Thread t=new Thread(()->{

            Double amountTransfer=100.0;
            printer1.accept(studentAccount,universityAccount);
            if(p1.test(studentAccount.getBalance(), amountTransfer)){
                printer.accept(Thread.currentThread().getName() + "says :: balance insufficient, ", amountTransfer);
            }else{
                try {


                    while (!studentAccount.transfer( amountTransfer,universityAccount)) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        continue;
                    }
                    printer2.accept(studentAccount,universityAccount);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        printer1.accept(studentAccount,universityAccount);
        System.out.println("********");
        for(int i=0;i<21;i++)
        ex.submit(t);

        ex.shutdown();


    }
}
