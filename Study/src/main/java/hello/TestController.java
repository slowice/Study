package hello;

import hello.ioc.bean.Foo;
import hello.entity.Student;
import hello.persist.AbstractBaseDao;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController extends AbstractBaseDao{
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    UserService userService;
    @Autowired
    Foo foo;

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request){
        System.out.println("into testController");
        System.out.println(foo);
        //userService.programmaticTransactionTest3();
        return "test";
    }

    @RequestMapping(value = "/testRest")
    @ResponseBody
    public String testRest(){
        Student s = (Student)applicationContext.getBean("hehe");
        System.out.println(s.getName());
        return "123";
    }
}
