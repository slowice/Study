package hello.concurrent;

import hello.dao.UserDao;
import hello.entity.User;
import hello.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
public class B implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            UserDao userDao = SpringUtil.getBean("userDao",UserDao.class);
            User user = new User();
            user.setId(i);
            user.setName(String.valueOf(i));
            userDao.insert(user);
            System.out.println("Thread b query time:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
