package com.hhuda.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReadWriteLockDemo {
    int sum=0;
    ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    void add(){
        readWriteLock.writeLock().lock();
        sum+=1;
        readWriteLock.writeLock().unlock();
    }

    void getSum(){
        readWriteLock.readLock().lock();
        System.out.println(sum);
        readWriteLock.readLock().unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ReadWriteLockDemo readWriteLockDemo=new ReadWriteLockDemo();
        IntStream.range(1,10000).forEach(x-> executorService.submit(readWriteLockDemo::add));
        executorService.submit(readWriteLockDemo::getSum);
        executorService.submit(readWriteLockDemo::getSum);
        executorService.submit(readWriteLockDemo::getSum);

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
