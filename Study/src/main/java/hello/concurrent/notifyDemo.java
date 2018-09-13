package hello.concurrent;

import java.util.concurrent.TimeUnit;

public class notifyDemo {
    static volatile Boolean shouldWait = true;
    public static void main(String[] args) {

        Object lock = new Object();
        Thread waiter = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while(shouldWait){
                        System.out.println("条件不满足，等待者进入等待");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) { }
                    }
                    System.out.println("条件满足，等待者执行任务");
                }
            }
        });

        ///通知线程执行完毕，才会重新执行等待线程
        Thread notifier = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    lock.notifyAll();
                    shouldWait = false;
                    System.out.println("通知者通知完毕");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (lock){
                    System.out.println("通知者再次获得锁，执行后续任务");
                }
            }
        });

        waiter.start();
        notifier.start();
    }
}
