package hello;

import hello.entity.Student;
import hello.entity.Student2;
import hello.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        File otherBank  = new File("E://otherBank.txt");
        String logs = "执行了他行扫描";
        OutputStream outputStream = new FileOutputStream(otherBank);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(logs);
        outputStreamWriter.close();
    }

    public void test(){
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

    public static void testReflect(Student model) throws Exception{
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(field.get(model)==null){
                System.out.println(
                        field.getName() + "is null"
                );
            }
        }
    }

    private static void test1(){
        //第一个斜杠无所谓
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        Student s = (Student) applicationContext.getBean("hehe");
        Student2 s2 = (Student2) applicationContext.getBean("hehe2");
        //第一个斜杠有区别,不加/是在这个工程的root目录下，加斜杠暂时不知道
        File f = new File("test.txt");
        File f2 = new File("/ceshi");
        System.out.println(f.exists());
        System.out.println(f2.exists());
        System.out.println(s2.name);
    }
}
