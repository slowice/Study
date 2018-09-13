package hello.aop.target_object.advice_test;

import hello.abs_interface.TestUtils;
import org.springframework.stereotype.Component;

@Component
public class AdviceTest extends TestUtils {
    public void testForAdvice(){
        System.out.println("目标类方法 ");
    }

    public void advice_thorwing_test(){
        System.out.println("目标类方法 ");
        throw new NullPointerException();
    }

    public String advice_returning_test(){
        System.out.println("目标类方法 ");
        return "123";
    }

    public String advice_aroud_test(){
        System.out.println("目标类方法 ");
        return "123";
    }
}
