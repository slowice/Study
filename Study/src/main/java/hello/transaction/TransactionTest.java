//package hello.transaction;
//
//import hello.service.UserService;
//import hello.util.TransactionUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * 事务处理测试
// */
//@Controller
//public class TransactionTest {
//    @Autowired
//    private TransactionUtil transactionUtil;
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 编程式事务处理  programmatic transaction
//     * programmaticTransactionTest1使用了select for update悲观锁将表锁住，并持续一段时间不释放锁
//     * programmaticTransactionTest2定时往数据库里插入一条数据。由于1会把表的写操作进行锁住。所以test2会被阻塞，但是若test2不插入只读取，则不会被阻塞
//     */
//    @RequestMapping("/programmaticTransactionTest")
//    public String programmaticTransactionTest(){
//        try {
//            /*boolean result2 = transactionUtil.transact(s -> userService.programmaticTransactionTest2());
//            Thread.sleep(500);
//            boolean result1 = transactionUtil.transact(s -> userService.programmaticTransactionTest1());
//
//            System.out.println("result1 "+result1+" result2 "+result2);*/
//            //userService.programmaticTransactionTest2();
//           // Thread.sleep(500);
//           // userService.programmaticTransactionTest1();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "test";
//    }
//}
