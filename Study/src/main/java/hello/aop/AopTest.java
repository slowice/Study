package hello.aop;

import hello.abs_interface.TestUtils;
import hello.aop.target_object.advice_test.AdviceTest;
import hello.aop.target_object.annotation_test.AnnoTationTest;
import hello.aop.target_object.args_test.ArgsTest;
import hello.aop.target_object.execution_test.ExecutionTest;
import hello.aop.target_object.this_target_bean_test.ThisTargetBeanTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopTest extends TestUtils{
    @Autowired
    private ProductService productService;
    @Autowired
    private hello.aop.target_object.within_test.WithinTest withinTest;
    @Autowired
    private ThisTargetBeanTest thisTargetBeanTest;
    @Autowired
    private ArgsTest argsTest;
    @Autowired
    private AnnoTationTest annoTationTest;
    @Autowired
    private ExecutionTest executionTest;
    @Autowired
    private AdviceTest adviceTest;

    //要求set admin
    @Test(expected = Exception.class)
    public void annoInsertTest(){
        CurrentUserHolder.set("tom");
        productService.delete(1L);
    }

    @Test()
    public void test1(){
        withinTest.say();
    }

    @Test()
    public void test2(){
        thisTargetBeanTest.say();
    }

    @Test()
    public void test3(){argsTest.say(1l);}

    @Test()
    public void test4(){annoTationTest.say();}

    @Test()
    public void execution_normal(){executionTest.say();}

    @Test()
    public void execution_exception(){
        executionTest.test_for_exception();
    }

    //测试advice after三连
    @Test()
    public void advice_after(){
        adviceTest.testForAdvice();
    }

    @Test(expected = NullPointerException.class)
    public void advice_afterthrowing(){
        adviceTest.advice_thorwing_test();
    }

    @Test()
    public void advice_afterreturning(){
        adviceTest.advice_returning_test();
    }

    @Test()
    public void advice_around(){
        adviceTest.advice_aroud_test();
    }
}
