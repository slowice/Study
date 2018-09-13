package hello.interfacetest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Properties;


public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Environment environment = applicationContext.getEnvironment();
        Properties properties = System.getProperties();
        Order groupOrder = new GroupOrder();
        Order insureOrder = new InsureOrder();
        groupOrder.getOrder();
        insureOrder.getOrder();
    }

}
