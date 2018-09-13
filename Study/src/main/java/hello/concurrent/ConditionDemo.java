package hello.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用来测试Condition的await和signal
 * 二者是基于LockSuport方法的，所以直接用这个上层封装的即可
 */
public class ConditionDemo {
    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo demo = new ConditionDemo();
        Thread1 t1 = demo.new Thread1();
        Thread2 t2 = demo.new Thread2();
        Thread3 t3 = demo.new Thread3();

        //执行顺序可能变化
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(t1);
        service.execute(t2);
        service.execute(t3);
        TimeUnit.SECONDS.sleep(2);

        demo.lock.lock();
        demo.c1.signal();
        demo.lock.unlock();
        TimeUnit.SECONDS.sleep(1);

        demo.lock.lock();
        demo.c2.signal();
        demo.lock.unlock();
        TimeUnit.SECONDS.sleep(1);

        demo.lock.lock();
        demo.c3.signal();
        demo.lock.unlock();
        TimeUnit.SECONDS.sleep(1);

        service.awaitTermination(6,TimeUnit.SECONDS);
        service.shutdown();
        System.out.println("执行完毕");
    }

    public class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("t1开始");
            lock.lock();
            try {
                System.out.println("t1等待");
                c1.await();
                System.out.println("t1唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    public class Thread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("t2开始");
            lock.lock();
            try {
                System.out.println("t2等待");
                c2.await();
                System.out.println("t2唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    public class Thread3 implements Runnable{
        @Override
        public void run() {
            System.out.println("t3开始");
            lock.lock();
            try {
                System.out.println("t3等待");
                c3.await();
                System.out.println("t3唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
