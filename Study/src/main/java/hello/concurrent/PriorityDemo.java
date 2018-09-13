package hello.concurrent;

import java.util.HashSet;
import java.util.Set;

public class PriorityDemo {
    private Set<Integer> s1 = new HashSet<>();
    private Set<Integer> s2 = new HashSet<>();

    public static void main(String[] args) throws InterruptedException {
        PriorityDemo demo = new PriorityDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100000;i++){
                    demo.s1add(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100000;i++){
                    demo.s2add(i);
                }
            }
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t2.start();
        t1.start();
        //Thread.sleep(1000l);
        t1.join(12l);
        t2.join(12l);

        System.out.println(demo.s1.size());
        System.out.println(demo.s2.size());
    }

    private void s1add(int i){
        s1.add(i);
    }

    private void s2add(int i){
        s2.add(i);
    }
}
