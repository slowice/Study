package hello.ioc;

import hello.entity.Student;
import hello.ioc.bean.Aoo;
import hello.ioc.context.ApplicationContextTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Test {

    @RequestMapping("/applicationContext1")
    public String test(HttpServletRequest request){
        ApplicationContextTest applicationContextTest = new ApplicationContextTest();
        ApplicationContext applicationContext = applicationContextTest.getXmlWebApplicationContext(request);
        Student student = (Student) applicationContext.getBean("hehe");
       // System.out.println(student.getName());
        return "123";
    }




    public static void test2(){
        ApplicationContext applicationContext = ApplicationContextTest.getApplicationContext();
        Aoo aoo = (Aoo) applicationContext.getBean("aoo");
        String[] arr=aoo.getStringArr();
        System.out.println(arr);
    }

    public static void main(String[] args) {
        test2();
    }


}
