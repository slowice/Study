package hello.temp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import sun.awt.windows.ThemeReader;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test2 {
    private final static Logger logger = LoggerFactory.getLogger(Test2.class);
    static class A{
        int x = 1;
    }

    public static void main(String[] args) {
        //threadTest();

    }


    public static void sort(String[] args) {

    }

    public static void quicksort1(int left,int right,int arr[],A a){
        int start = left;
        int end = right;
        int base = arr[left];
        if(start>=end){
            return;
        }
        while (start!=end){
            while(start<end && arr[end]>=base){
                end--;
            }
            while(start<end && arr[start]<=base){
                start++;
            }
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        a.x++;
        int temp = arr[left];
        arr[left] = arr[start];
        arr[start] = temp;
        quicksort1(left,start-1,arr,a);
        quicksort1(start+1,right,arr,a);
    }

    //冒泡排序
    public static void maopaosort(int[] arr,A a) {
        for(int j=1;j<arr.length;j++) {
            for (int i = 0; i < arr.length - j; i++) {
                a.x++;
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                }
            }
        }
    }

    //快速排序
    public static void quicksort(int low,int high,int arr[],A a){
        int start = low;
        int end = high;
        int temp;
        if(start>end){
            return;
        }
        while(start!=end){
            while (end>start&&arr[end]>=arr[low]){
                end--;
            }
            while (end>start&&arr[start]<=arr[low]){
                start++;
            }
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            a.x++;
        }
        temp = arr[start];
        arr[start] = arr[low];
        arr[low] = temp;
        quicksort(low,start-1,arr,a);
        quicksort(start+1,high,arr,a);
    }

    //日期操作
    public static void timetest(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH,5);
        calendar.set(2012,8,8,12,12,12);
        String time2 = simpleDateFormat.format(calendar.getTime());
        System.out.println(time2);
    }

    //redis测试
    public static void hehe(){
        /*//连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost",6379);
        String key = Constants.Redis.getPropertyName();
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());*/
       /* ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring-redis.xml");
        JedisPoolUtils jedisPoolUtils = (JedisPoolUtils)ac.getBean("jedisPoolUtils");
        try {
            String x = jedisPoolUtils.set("aaaaaaaa","aaaaaaa");
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
