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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinWork extends RecursiveTask<Long> {
    long start;
    long end;
    long middle=2000/20;
    AtomicInteger m = new AtomicInteger(0);
    List<RefPartExcel> excelBeans;
//    public ForkJoinWork(Long start,Long end){
//        this.start = start;
//        this.end = end;
//    }
    public ForkJoinWork(List<RefPartExcel> excelBeans){
        this.excelBeans = excelBeans;
    }

    @Override
    protected Long compute() {
//        Long length = this.end - this.start;
//
//        if(length<middle){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            BigInteger sum = new BigInteger("0");
//            for(long i = start;i<end;i++){
//                sum = sum.add(new BigInteger(String .valueOf(i)));
//            }
//            return sum;
//        } else {
//            long middle2 = (start+end)/2;
//            try {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            ForkJoinWork left = new ForkJoinWork(start,middle2);
//            ForkJoinWork right = new ForkJoinWork(middle2+1,end);
//            left.fork();
//            right.fork();
//            BigInteger a = left.join();
//            BigInteger b = right.join();
//            return  a.add(b).add(new BigInteger("-1"));
//        }

        if(excelBeans.size()<=3){
            long sum = 0;
            for(RefPartExcel refPartExcel : excelBeans){
                sum+=Integer.parseInt(refPartExcel.getRefPartNo());
            }
            return sum;
        }else {
            ForkJoinWork left = new ForkJoinWork(excelBeans.subList(0,excelBeans.size()/2));
            ForkJoinWork right = new ForkJoinWork(excelBeans.subList((excelBeans.size()/2),excelBeans.size()));
            left.fork();
            right.fork();
            return left.join() + right.join();
        }

    }
}
