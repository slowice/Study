package hello.pattern.producerAndConsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {

    public static void main(String[] args) {

    }
    private class Producer{
        private LinkedBlockingQueue linkedBlockingQueue;
        public Producer(LinkedBlockingQueue linkedBlockingQueue){
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        public void produce() throws InterruptedException {
            int i =1;
            linkedBlockingQueue.put(i);
        }
    }
    private class Consumer{
        private LinkedBlockingQueue linkedBlockingQueue;
        public Consumer(LinkedBlockingQueue linkedBlockingQueue){
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        public void comsume(){
            //int x = linkedBlockingQueue.offer()
        }
    }
}
