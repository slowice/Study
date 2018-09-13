package xb.properties_test.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesDemo {
    @Value("${xb.book}")
    private static String xx;

    public static void main(String[] args) {

        System.out.println(xx);
    }
}
