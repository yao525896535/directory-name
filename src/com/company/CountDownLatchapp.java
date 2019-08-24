package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchapp {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool() ; //创建了线程池，要多少线程就有多少线程的
        final CountDownLatch cdl = new CountDownLatch(10) ;
        for (int i=0; i < 10; i++) {
            Runnable runn = new Runnable() {
                public void run() {
                    cdl.countDown() ;//每次调用减去1
                    try {
                        cdl.await() ;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            };
            System.out.println( cdl.getCount() + "秒" ) ;
            exec.execute(runn) ;
        }
        cdl.getCount();
    }
}