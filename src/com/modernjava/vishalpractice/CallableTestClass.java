package com.modernjava.vishalpractice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallableTestClass {

    public static int[] number= IntStream.rangeClosed(0,5000).toArray();
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable1=()->{
            Integer sum=0;
          for (int i=0;i< number.length/2;i++){
              sum=sum+number[i];
          }
          return sum;
        };

        Callable callable2=()->{
            Integer sum=0;
            for (int i=number.length/2;i< number.length ;i++){
                sum=sum+number[i];
            }
            return sum;
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
       List<Callable<Integer>>  intList=Arrays.asList(callable1,callable2);
       List<Future<Integer>> lists=executorService.invokeAll(intList);
      //  List<Future<Integer>> lists=executorService.invokeAll(Arrays.asList(callable1,callable2));


   }

}

