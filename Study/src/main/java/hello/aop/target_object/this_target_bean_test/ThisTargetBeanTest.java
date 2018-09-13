package hello.aop.target_object.this_target_bean_test;

import org.springframework.stereotype.Component;

@Component
public class ThisTargetBeanTest implements ThisTargetBeanInterface{
    public void say(){
        System.out.println("hehe");
    }
}
