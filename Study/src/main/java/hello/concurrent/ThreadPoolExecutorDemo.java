package hello.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 * 若线程繁忙，则不论是shutdown还是shutdownnow都是不能中断线程的
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,180, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
        executor.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                }
            }
        });
        //executor.shutdownNow();
        executor.shutdown();
        executor.awaitTermination(2,TimeUnit.SECONDS);
        System.out.println(        executor.isTerminated());
    }
}
