package hello.concurrent;

public class joinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    System.out.println("A"+i);
                }
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    System.out.println("B"+i);
                }
            }
        });

        A.start();
        A.join();
        B.start();
        B.join();
        System.out.println("程序执行完毕");
    }
}
