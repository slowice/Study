package hello.temp;


import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author i2finacne
 */
public class RizaHawkeye{
    static volatile int i=0;
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(8,8,10L,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(2000));
    private class TaskA{

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                i+=1;
            }
        });

        System.out.println(i);
    }
}
