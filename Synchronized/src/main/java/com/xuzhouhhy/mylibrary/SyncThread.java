package com.xuzhouhhy.mylibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by hanhongyun on 2019/2/18 14:51
 */
public class SyncThread implements Runnable {

    public static void main(String... args) {
        SyncThread syncThread = new SyncThread();
        Thread aThread1 = new Thread(syncThread, "A_thread1");
        Thread aThread2 = new Thread(syncThread, "A_thread2");
        Thread b_thread1 = new Thread(syncThread, "B_thread1");
        Thread b_thread2 = new Thread(syncThread, "B_thread2");
        Thread c_thread1 = new Thread(syncThread, "C_thread1");
        Thread c_thread2 = new Thread(syncThread, "C_thread2");
        aThread1.start();
        aThread2.start();
        b_thread1.start();
        b_thread2.start();
        c_thread1.start();
        c_thread2.start();

        Thread A_thread1 = new Thread(new SyncThread(), "A_thread1");
        Thread A_thread2 = new Thread(new SyncThread(), "A_thread2");
        Thread B_thread1 = new Thread(new SyncThread(), "B_thread1");
        Thread B_thread2 = new Thread(new SyncThread(), "B_thread2");
        Thread C_thread1 = new Thread(new SyncThread(), "C_thread1");
        Thread C_thread2 = new Thread(new SyncThread(), "C_thread2");
        A_thread1.start();
        A_thread2.start();
        B_thread1.start();
        B_thread2.start();
        C_thread1.start();
        C_thread2.start();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (name.startsWith("A")) {
            asyncTest();
        } else if (name.startsWith("B")) {
            syncBlockTest();
        } else if (name.startsWith("C")) {
            syncFunctionTest();
        }
    }

    private synchronized void syncFunctionTest() {
        System.out.println(Thread.currentThread().getName() +
                "_Sync2: " +
                SimpleDateFormat.getDateTimeInstance().format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() +
                    "_Sync2_Start: " +
                    SimpleDateFormat.getDateTimeInstance().format(new Date()));

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() +
                    "_Sync2_End: " +
                    SimpleDateFormat.getDateTimeInstance().format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void syncBlockTest() {
        System.out.println(Thread.currentThread().getName() +
                "_Sync1: " +
                SimpleDateFormat.getDateTimeInstance().format(new Date()));

        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() +
                        "_Sync1_Start: " +
                        SimpleDateFormat.getDateTimeInstance().format(new Date()));

                Thread.sleep(2000);

                System.out.println(Thread.currentThread().getName() +
                        "_Sync1_End: " +
                        SimpleDateFormat.getDateTimeInstance().format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void asyncTest() {
        try {
            System.out.println(Thread.currentThread().getName() +
                    "_Async_Start: " +
                    SimpleDateFormat.getDateTimeInstance().format(new Date()));

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() +
                    "_Async_End: " +
                    SimpleDateFormat.getDateTimeInstance().format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
