package hello.pattern.producerAndConsumer.comsumer;

import hello.entity.User;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class UserConsumer implements Runnable{
    private LinkedBlockingQueue<User> queue;
    private static final int SLEEPTIME = 1000;

    public UserConsumer(LinkedBlockingQueue<User> queue){
        this.queue = queue;
    }

    private void consume() throws InterruptedException {
        User user = queue.take();
        System.out.println("用户" + user.getId() + "已经被移除");
    }

    @Override
    public void run() {
        System.out.println("start consumer ,the ThreadId is "+Thread.currentThread().getId());
        Random r = new Random();
        try{
            while(true){
                User user = queue.take();
                if(user != null){
                    int re = user.getId();
                    System.out.println("获取到了User, id is "+user.getId());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
