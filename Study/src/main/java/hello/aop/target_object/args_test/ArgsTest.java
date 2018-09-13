package hello.aop.target_object.args_test;

import org.springframework.stereotype.Component;

@Component
public class ArgsTest {
    public void say(Long l){
        l = 1l;
        System.out.println("this is "+this.getClass().getName());
    }
}
