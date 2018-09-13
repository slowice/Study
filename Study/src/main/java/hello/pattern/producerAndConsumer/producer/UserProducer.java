package hello.pattern.producerAndConsumer.producer;

import hello.entity.User;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UserProducer implements Runnable{
    private LinkedBlockingQueue<User> queque;
    private AtomicInteger id = new AtomicInteger(1);
    private volatile boolean isRunning = true;

    public UserProducer(LinkedBlockingQueue<User> queque){
        this.queque=queque;
    }

    @Override
    public void run() {
        User user;
        Random r = new Random();
        System.out.println("Produce thread is running,the id is " + Thread.currentThread().getId());
        try{
            while (isRunning){
                //Thread.sleep(r.nextInt());
                user = new User();
                user.setId(id.getAndIncrement());
                System.out.println(user + "加入队列");
                if(queque.offer(user,2, TimeUnit.SECONDS)){
                    System.out.println(user+"加入队列失败");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.isRunning = false;
    }
}
