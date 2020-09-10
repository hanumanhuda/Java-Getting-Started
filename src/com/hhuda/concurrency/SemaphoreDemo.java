package com.hhuda.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class SemaphoreDemo {
    Semaphore semaphore =new Semaphore(5);
    void runTask()  {
        boolean permit=false;
        try {
            permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            if (permit) {
                System.out.println("Lock Acquired");
                sleep(5000);
            } else {
                System.out.println("Lock not acquired");
            }
        }catch (InterruptedException ie){
            System.out.println("IE");
        }finally {
            if (permit){
                semaphore.release();
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        SemaphoreDemo semaphoreDemo= new SemaphoreDemo();
        IntStream.range(1,10).forEach(x-> executorService.submit(semaphoreDemo::runTask));

    }
}
