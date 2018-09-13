package hello.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

public class DateUtil {
    public static void printNow(){
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }

    public static void printDate(Long time){
        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd hh:mm:ss").format(new Date(time)));
    }
}
