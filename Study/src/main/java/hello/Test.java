package hello;

import hello.entity.Student;
import hello.entity.User;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;


import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Test {

    public static void main(String[] args) throws Exception {
        /*File otherBank  = new File("E://otherBank.txt");
        String logs = "执行了他行扫描";
        OutputStream outputStream = new FileOutputStream(otherBank);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(logs);
        outputStreamWriter.close();*/
        //test3();
        //test5();
       /* int a=1;
        int b =32312;
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a);
        System.out.println(b);
        Map map = new HashMap<>();*/
        /*Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3,5,6));
        s1.retainAll(s2);
        System.out.println(s1);*/
        //Runtime.getRuntime().exec("open /Users/xubin/Applications/123.txt");

        String arr = "1";
        List list = Arrays.asList(arr.split(","));
        System.out.println(list);


    }

    private static class runner implements Runnable {
        private volatile boolean flag = true;

        @Override
        public void run() {
            while (flag && !Thread.currentThread().isInterrupted()) {
                System.out.println("xxx");
                //TimeUnit.MILLISECONDS.sleep(500);
            }
        }
        void cancel() {
            this.flag = false;
        }
    }

    //测试中文编码
    public void test() {
          /*String filePath = "D://test.txt";
        String charset = "UTF-8";

        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,charset);
        osw.write("中文编码测试");
        osw.close();

        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis,charset);
        StringBuffer buffer = new StringBuffer();
        char[] arr = new char[64];
        int count = 0;
        while((count=isr.read(arr))!=-1){
            buffer.append(arr,0,count);
            System.out.println(buffer);
        }
        isr.close();*/
    }

    //测试类的域反射
    public static void testReflect(Student model) throws Exception {
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(model) == null) {
                System.out.println(
                        field.getName() + "is null"
                );
            }
        }
    }

    //测试路径中的斜杠
    private static void test1() {
        //第一个斜杠无所谓
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        Student s = (Student) applicationContext.getBean("hehe");
        //第一个斜杠有区别,不加/是在这个工程的root目录下，加斜杠暂时不知道
        File f = new File("test.txt");
        File f2 = new File("/ceshi");
        System.out.println(f.exists());
        System.out.println(f2.exists());
    }

    //toLowerCase的异常处理范式
    public static void test6() {
        String x = "AAA";
        x.toLowerCase();
    }

    public static void test8(){
        Set<String> set = new TreeSet<>();
        set.add("d");
        set.add("c");
        set.add("b");
        set.add("a");

        for(String x:set){
            System.out.println(x);
        }
    }

    private static class Student_ {
        String s_no;
        String s_age;
        String s_name;

        public String getS_no() {
            return s_no;
        }

        public void setS_no(String s_no) {
            this.s_no = s_no;
        }

        public String getS_age() {
            return s_age;
        }

        public void setS_age(String s_age) {
            this.s_age = s_age;
        }

        public String getS_name() {
            return s_name;
        }

        public void setS_name(String s_name) {
            this.s_name = s_name;
        }
    }
    //Test for comparator
    public static void comparatorTest(){
        Student_ s1 = new Student_();
        s1.setS_no("1");
        s1.setS_age("19");
        s1.setS_name("di yi");

        Student_ s2 = new Student_();
        s2.setS_no("2");
        s2.setS_age("18");
        s2.setS_name("di er");

        Student_ s3 = new Student_();
        s3.setS_no("2");
        s3.setS_age("17");
        s3.setS_name("di san ");

        Comparator no = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student_ s1 = (Student_)o1;
                Student_ s2 = (Student_)o2;
                if(Integer.parseInt(s1.getS_no())>Integer.parseInt(s2.getS_no())){
                    return 1;
                }else if(Integer.parseInt(s1.getS_no())<Integer.parseInt(s2.getS_no())){
                    return -1;
                }else return 0;
            }
        };

        Comparator age = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student_ s1 = (Student_)o1;
                Student_ s2 = (Student_)o2;
                if(Integer.parseInt(s1.getS_age()) > Integer.parseInt(s2.getS_age())){
                    return 1;
                }else if(Integer.parseInt(s1.getS_age())<Integer.parseInt(s2.getS_age())){
                    return -1;
                }else return 0;
            }
        };

        List<Student_> list = new ArrayList<Student_>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list,no);
        for(Student_ s : list){
            System.out.println( s.getS_name() );
        }
        Collections.sort(list, age);
        for(Student_ s:list){
            System.out.println( s.getS_name());
        }
    }

    public static void test7(){
        Date date = new Date();

        String now = FastDateFormat.getInstance("MM月dd日").format( DateUtils.addDays(date,-1));
        System.out.println(now);
    }
}
