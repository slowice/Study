package hello.aop;

import hello.abs_interface.TestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect extends TestUtils{
    @Autowired
    private AuthService authService;

    //匹配某一类型
    @Pointcut("within(hello.aop.target_object.within_test.WithinTest)")
    public void matchType(){ }
    @Before("matchType()")
    public void check1(){
        authService.say();
    }

    //匹配某一包,注意这个地方不能知道包那一层，一定要用.*
    @Pointcut("within(hello.aop.target_object.within_test..*)")
    public void matchPackage(){ }
    @Before("matchPackage()")
    public void check2(){
        authService.say();
    }

    //匹配某一对象
    @Pointcut("this(hello.aop.target_object.this_target_bean_test.ThisTargetBeanInterface)")
    public void thisDemo(){}
    @Before("thisDemo()")
    public void check3(){
        System.out.println("aop_this匹配");
    }

    //匹配某一对象
    @Pointcut("target(hello.aop.target_object.this_target_bean_test.ThisTargetBeanInterface)")
    public void targetDemo(){ }
    @Before("targetDemo()")
    public void check4(){
        System.out.println("aop_target匹配");
    }

    //匹配以Test结尾的bean
    @Pointcut("bean(*Test)")
    public void beanTest(){}
    @Before("beanTest()")
    public void check5(){
        System.out.println("aop_bean匹配,匹配以Test结尾的BEAN");
    }

    //匹配参数
    @Pointcut("args(Long) && within(hello.aop.target_object.args_test.*)")
    public void argsTest(){}
    @Before("argsTest()")
    public void check6(){
        System.out.println("aop_args匹配，并且加入了在argsTest包内的限制");
    }

    //匹配注解
    @Pointcut("@annotation(hello.aop.target_object.annotation_test.AdminOnly)")
    public void adminOnly(){}
    @Before("adminOnly()")
    public void check(){
        authService.checkAccess();
    }

    //匹配Beta注解的类下面的方法,并且Beta注解的RetentionPolicy为CLASS
    @Pointcut("@within(hello.aop.target_object.annotation_test.Beta)")
    public void annoWithinDemo(){}
    @Before("annoWithinDemo()")
    public void check7(){
        System.out.println("aop_类级别@within注解匹配");
    }

    //同上但是要求RetentionPolicy为Runtime
    /*@Pointcut("@target(Coco)")
    public void annoTargetDemo(){}
    @Before("annoTargetDemo()")
    public void check8(){
        System.out.println("aop_类级别注解@target的匹配");
    }*/

    //匹配execution，executionTest后面的两个点代表任意子包，括号中的..代表任意参数
    @Pointcut("execution(public * hello.aop.target_object.execution_test..ExecutionTest.*(..))")
    public void executionDemo(){}
    @Before("executionDemo()")
    public void check8(){
        System.out.println("aop_匹配execution");
    }

    //匹配execution，executionTest后面的两个点代表任意子包，括号中的..代表任意参数
    @Pointcut("execution(public * hello.aop.target_object.execution_test..ExecutionTest.*(..) throws java.lang.Exception)")
    public void executionDemo2(){}
    @Before("executionDemo2()")
    public void check9(){
        System.out.println("aop_匹配execution_exception");
    }



    @Pointcut("execution(* hello.aop.target_object.advice_test.AdviceTest.*())")
    public void adviceDemo(){
        System.out.println("adviceMethod");
    }

    @After("adviceDemo()")
    public void afterDemo(){
        System.out.println("切面打印，匹配after");
    }

    @AfterThrowing("adviceDemo()")
    public void afterThrowingDemo(){
        System.out.println("切面打印，匹配afterThrowingDemo");
    }

    @AfterReturning(value = "adviceDemo()",returning = "result")
    public void afterReturningDemo(Object result){
        if(result instanceof String){
            System.out.println("切面打印，匹配afterReturning"+"结果是"+result.toString());
        }
        System.out.println();
    }

    @Around("adviceDemo()")
    public Object aroundDemo(ProceedingJoinPoint joinPoint){
        Object result = null;
        try{
            System.out.println("around--执行前");
            result = joinPoint.proceed(joinPoint.getArgs());
            System.out.println("around--执行后");
            throw new Exception();

        } catch (Throwable e) {
            System.out.println("around异常出现");
            e.printStackTrace();
        } finally {
            System.out.println("around--finally");
        }
        return null;
    }

}
