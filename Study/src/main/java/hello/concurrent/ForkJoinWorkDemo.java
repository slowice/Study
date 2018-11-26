package hello.concurrent;

import hello.io.ExcelUtil;
import hello.io.RefPartExcel;
import org.apache.poi.util.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinWorkDemo {
    public static void test1(){
        long l = System.currentTimeMillis();



        File file = new File("/Users/xubin/1.xlsx");
        FileInputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = null;
        try {
            multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        List<RefPartExcel> excelBeans = null;
        // 判断文件是否为空
        if (file != null) {
            try {
                excelBeans = ExcelUtil.readExcel(multipartFile, RefPartExcel.class);
                System.out.println(excelBeans.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinWork task = new ForkJoinWork(excelBeans);
        long invoke = forkJoinPool.invoke(task);
        long ll = System.currentTimeMillis();
        System.out.println("forkjoin耗时 "+ (ll - l)/1000 + "秒"+"结果是 "+invoke);
    }
//381454726773252
//2035152
    //2035152
    public static void test2(){
        int start = 2;
       // long end = 100000000L;
        int end = 2017;
        long sum = 0;
        long l = System.currentTimeMillis();
        for(int i=start;i<=end;i++){
            sum += i;
        }
        long ll = System.currentTimeMillis();
        System.out.println("单线程耗时   "+ (ll - l)/1000 + "秒"+"结果是 "+sum);
    }
    //10
    //36
    public static void test3(){
        int start =0;
        int end = 10;

        BigInteger sum = new BigInteger(String.valueOf(start));
        for(long i = start;i<end;i++){
            sum = sum.add(new BigInteger(String .valueOf(i)));
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        test1();
        //test2();
    }
}
