package hello;

import hello.bean.Foo;
import hello.concurrent.A;
import hello.concurrent.B;
import hello.dao.InsureLogDao;
import hello.dao.UserDao;
import hello.entity.Student;
import hello.entity.User;
import hello.logshandler.entity.InsureLog;
import hello.persist.AbstractBaseDao;
import hello.service.UserService;
import hello.util.TransactionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
