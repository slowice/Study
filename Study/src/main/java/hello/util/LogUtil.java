package hello.util;

import java.util.concurrent.TimeUnit;

public class LogUtil {
    public static String formatLog(String resource){
        return getLogSign()+resource+getLogSign();
    }
    private  static String getLogSign(){
        return "******************************";
    }

    public static void countUp() throws InterruptedException {
        for(int i=1;i<=Integer.MAX_VALUE;i++){
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
