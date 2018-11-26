//package hello;
//
//import hello.dto.ResponseDTO;
//import hello.entity.RandomObj;
//import hello.entity.User;
//import hello.ioc.bean.Foo;
//import hello.entity.Student;
//import hello.persist.AbstractBaseDao;
//import hello.service.DbTestService;
//import hello.service.UserService;
//import hello.transaction.CustomizeTransactionTest;
//import hello.dao.DbTest;
//import hello.transaction.TestModel;
//import hello.util.LogUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.Assert;
//import org.springframework.util.ClassUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping(value = "/test")
//public class TestController extends AbstractBaseDao{
//    //region field inject
//    @Autowired
//    ApplicationContext applicationContext;
//    @Autowired
//    UserService userService;
//    @Autowired
//    Foo foo;
//    @Autowired
//    DbTestService dbTestService;
//    //endregion
//
//    @RequestMapping("/temp")
//    public void test2(HttpServletResponse response) throws IOException {
//        userService.test(response);
//    }
//
//    //Controller test
//    @RequestMapping(value = "/test")
//    public String test(HttpServletRequest request){
//        System.out.println("into testController123");
//        return "test";
//    }
//
//    //ResponseBody test
//    @RequestMapping(value = "/testRest")
//    @ResponseBody
//    public String testRest() throws InvocationTargetException, IllegalAccessException {
//        User user = new User();
//        user.setName("abg");
//        user.setId(1);
//        ResponseDTO responseDTO = new ResponseDTO("00",user);
//        return responseDTO.toString();
//    }
//
//    //dispatcher with modelAndView
//    @RequestMapping("/testModelAndView")
//    public ModelAndView testModelAndView(){
//        System.out.println("12345");
//        ModelAndView modelAndView = new ModelAndView("testModelAndViewFTL");
//        Map<String,String> map = new HashMap<>();
//        map.put("name","abg");
//        modelAndView.addObject(map);
//        System.out.println( ClassUtils.getQualifiedName(Map.class));
//        return  modelAndView;
//    }
//
//    //region crud with mysql and mybatis
//    @RequestMapping("/addDemo")
//    @ResponseBody
//    public String addDemo(){
//        User user = new User();
//        user.setId(2);
//        user.setName("123");
//        userService.insert(user);
//        return new ResponseDTO("00","success").toString();
//    }
//
//    @RequestMapping("/selDemo")
//    @ResponseBody
//    public String selDemo(){
//        User user = userService.select(1);
//        Assert.notNull(user,"not null");
//        return new ResponseDTO("00","success").toString();
//    }
//
//    @RequestMapping("/delDemo")
//    @ResponseBody
//    public String delDemo(){
//        User user = new User();
//        user.setId(2);
//        userService.delete(user);
//        return new ResponseDTO("00","success").toString();
//    }
//
//    @RequestMapping("/updateDemo")
//    @ResponseBody
//    public String updateDemo(){
//        User user = userService.select(2);
//        user.setName("abg2");
//        userService.update(user);
//        return new ResponseDTO("00","success").toString();
//    }
//
//    //endregion
//
//    //region crud with h2 database
//    @RequestMapping("/h2create")
//    public void h2create(){
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(CustomizeTransactionTest.class);
//        annotationConfigApplicationContext.refresh();
//        DbTest dbTest = annotationConfigApplicationContext.getBean(DbTest.class);
//        dbTest.createTable();
//        System.out.println(LogUtil.formatLog("建表成功"));
//    }
//
//    @RequestMapping(value = "/h2add")
//    public void h2add(){
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(CustomizeTransactionTest.class);
//        annotationConfigApplicationContext.refresh();
//        DbTest dbTest = annotationConfigApplicationContext.getBean(DbTest.class);
//        dbTest.add(new TestModel("test"));
//        logger.info(String.valueOf(dbTest.count()));
//        System.out.println(LogUtil.formatLog("新增成功"));
//    }
//
//    @RequestMapping(value = "/h2addException")
//    public void h2addException(){
//        dbTestService.add();
//    }
//
//    @RequestMapping(value = "/h2count")
//    public void h2count(){
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(CustomizeTransactionTest.class);
//        annotationConfigApplicationContext.refresh();
//        DbTest dbTest = annotationConfigApplicationContext.getBean(DbTest.class);
//        logger.info("内存中数据是啊啊啊啊啊啊"+String.valueOf(dbTest.count()));
//    }
//    //endregion
//
//}
