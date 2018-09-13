package hello.pattern.producerAndConsumer.product;

import hello.entity.User;
import hello.pattern.producerAndConsumer.comsumer.UserConsumer;
import hello.pattern.producerAndConsumer.producer.UserProducer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class UserProduct {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<User> queue = new LinkedBlockingQueue<User>(10);
        UserProducer p1 = new UserProducer(queue);
        UserProducer p2 = new UserProducer(queue);
        UserProducer p3 = new UserProducer(queue);
        UserConsumer c1 = new UserConsumer(queue);
        UserConsumer c2 = new UserConsumer(queue);
        UserConsumer c3 = new UserConsumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(c1);
       /* service.execute(p2);
        service.execute(p3);

        service.execute(c2);
        service.execute(c3);*/
        Thread.sleep(5000);
        p1.stop();
        p2.stop();
        p3.stop();
        Thread.sleep(3000);
        service.shutdown();
        for(User user:queue){
            System.out.println(user);
        }
    }
}
