package hello.aop.target_object.execution_test;

import org.springframework.stereotype.Component;


@Component
public class ExecutionTest{

    public void say() {
        System.out.println("this class is "+this.getClass().getName());
    }

    public void test_for_exception (){
        try{
            System.out.println("this class is "+this.getClass().getName());
        }catch (Exception e){
            System.out.println(" exception ");
        }
    }

    public String test_for_after_returning(){
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElement[1].getMethodName());
        return "123";
    }
}
