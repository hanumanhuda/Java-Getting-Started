package com.hhuda.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class SynchronizedDemo {
    int sum=0;
     synchronized void add()  {
        sum+=1;
        try {
            sleep(1);
        }catch(InterruptedException ie){
            System.out.println("IE");
        }
    }
    int getSum(){
        return sum;
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1000);
        SynchronizedDemo  synchronizedDemo =new SynchronizedDemo();
        Long startTime = System.currentTimeMillis();
        IntStream.range(1,10000).forEach(x-> executorService.submit(synchronizedDemo::add));
        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
        Long endTime = System.currentTimeMillis();
        Long runtime = endTime-startTime;

        System.out.println("Total Count: "+synchronizedDemo.getSum());
        System.out.println("Total Time: "+ runtime);
    }
}
