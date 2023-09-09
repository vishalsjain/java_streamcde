package com.modernjava.funcprogramming.realexample.vishaltest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

public class BankAccountPojo {

    private int id;

    public BankAccountPojo(int id, Double balance, String accountName) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "BankAccountPojo{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBalance() {

   return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    private Double balance;
    private String accountName;

    public Lock lock=new ReentrantLock();

    BiFunction<Double,Double,Double> addAmount= Double::sum;
    BiFunction<Double,Double,Double> subAmount=(a, b)-> (a-b);

    public boolean deposit(Double amount) throws InterruptedException {

        if (lock.tryLock()){
            System.out.println(Thread.currentThread().getName()+"Ack Lock:"+getAccountName()+"Balnce:"+balance+"amount:"+amount);
            Thread.sleep(100);
            balance = addAmount.apply(amount,this.balance);
            lock.unlock();
            System.out.println("Ack Lock Release:"+getAccountName()+"NewBalnce:"+balance);
            return true;
        }
        return false;
    }

    public boolean withdraw(Double amount) throws InterruptedException {

        if(lock.tryLock()){
            System.out.println("Ack Lock:"+getAccountName()+"Balnce:"+balance+"amount:"+amount);
            Thread.sleep(100);
            balance=subAmount.apply(this.balance,amount);
            lock.unlock();
            System.out.println("Ack Lock Release:"+getAccountName()+"NewBalnce:"+balance);
            return true;
        }
        return false;
    }
    public boolean transfer(Double amount,BankAccountPojo toAccount) throws InterruptedException {

        if(this.getBalance()<amount)
            return false;
        if(this.withdraw(amount)){
            if(toAccount.deposit(amount)){
                return true;
            }else{
                System.out.println("RollBack Transfer"+Thread.currentThread().getName());

      while(this.deposit(amount))
          return false;
                return false;
            }
        }
        return false;
    }


}
