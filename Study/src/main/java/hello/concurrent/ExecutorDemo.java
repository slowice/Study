package hello.concurrent;

import hello.util.LogUtil;
import hello.util.StringUtil;

import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        scheduledThreadPoolExucutorTest();
    }

    public static void futureTest() throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "call done";
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
    }

    public static void futureTaskTest() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("futureTask running");
                return "futureTaks end";
            }
        });
        futureTask.run();
        while(true){
            if(null!=futureTask.get()){
                System.out.println("1111111111111111111111111");
                System.out.println(futureTask.get());
            }
        }
    }

    public static void scheduledThreadPoolExucutorTest() throws InterruptedException {
        ScheduledThreadPoolExecutor  scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        };
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(task,2,4,TimeUnit.SECONDS);//等待2秒后，每4秒执行一次
        LogUtil.countUp();
    }

}
