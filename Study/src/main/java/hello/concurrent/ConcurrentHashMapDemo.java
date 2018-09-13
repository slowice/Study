package hello.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapDemo {
    private static Map<String,Object> map;
    private static AtomicInteger m = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        //map = new ConcurrentHashMap<String,Object>(150);
        map = new HashMap<>(150);
        for(int z = 0;z<100;z++){
            int count = testForExcutor();
            if(count<150){
                System.out.println(count);
                throw new IllegalStateException();
            }
            map.clear();
        }
    }

    private static int testForExcutor() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(
                3);
        for(int i=0;i<3;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<50;j++){
                        //map.put(String.valueOf( m.incrementAndGet()), m.incrementAndGet());
                        map.putIfAbsent(String.valueOf( m.incrementAndGet()), m.incrementAndGet());
                    }
                }
            });
        }
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        return map.size();
    }
}
