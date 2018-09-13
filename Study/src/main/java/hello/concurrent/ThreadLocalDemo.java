package hello.concurrent;

import hello.util.DateUtil;
import org.apache.commons.lang3.time.DatePrinter;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static long start(){
        long start = System.currentTimeMillis();
        DateUtil.printDate(start);
        threadLocal.set(start);
        return start;
    }

    public static long end(){
        long start = threadLocal.get();
        long end = System.currentTimeMillis();
        long between = end-start;
        DateUtil.printDate(end);
        System.out.println("相隔时间为：" + between + "ms");
        return  end;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo.start();
        TimeUnit.SECONDS.sleep(2);
        ThreadLocalDemo.end();
    }
}
