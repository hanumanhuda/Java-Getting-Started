package com.hhuda.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockDemo {
    int sum=0;
    ReentrantLock lock=new ReentrantLock();
    void add(){
        lock.lock();
        sum+=1;
        lock.unlock();
    }
    int getSum(){
        return sum;
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1000);
        ReentrantLockDemo  reentrantLockDemo =new ReentrantLockDemo();
        Long startTime = System.currentTimeMillis();
        IntStream.range(1,10000).forEach(x-> executorService.submit(reentrantLockDemo::add));
        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
        Long endTime = System.currentTimeMillis();
        Long runtime = endTime-startTime;

        System.out.println("Total Count: "+reentrantLockDemo.getSum());
        System.out.println("Total Time: "+ runtime);
    }
}
