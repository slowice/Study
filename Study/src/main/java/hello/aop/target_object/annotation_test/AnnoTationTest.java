package hello.aop.target_object.annotation_test;

import org.springframework.stereotype.Component;

@Beta
@Coco
@Component
public class AnnoTationTest {
    public void say(){
        System.out.println("this is "+this.getClass().getName());
    }
}
