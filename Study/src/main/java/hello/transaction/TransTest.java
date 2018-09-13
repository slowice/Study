package hello.transaction;

import hello.entity.User;
import hello.logshandler.entity.InsureLog;
import hello.service.InsureLogService;
import hello.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransTest {
    @Autowired
    UserService userService;
    @Autowired
    InsureLogService insureLogService;

    @Test()
    @Transactional
    public void test(){
        InsureLog log = new InsureLog();
        log.setPaySend("123");
        insureLogService.insert(log);

        User user = new User();
        user.setId(123);
        user.setName("123");
        userService.insert(user);
    }

    @Test()
    public void insertLog(){
        InsureLog log = new InsureLog();
        log.setPaySend("123");
        insureLogService.insert(log);
    }

}
